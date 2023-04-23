package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.Entities.Book;
import com.example.LibraryManagementSystem.Entities.Card;
import com.example.LibraryManagementSystem.Entities.Transaction;
import com.example.LibraryManagementSystem.Enums.Status;
import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Repositories.BookRepository;
import com.example.LibraryManagementSystem.Repositories.CardRepository;
import com.example.LibraryManagementSystem.Repositories.TransactionRepository;
import com.example.LibraryManagementSystem.RequestDtos.IssueBookRequestDto;
import com.example.LibraryManagementSystem.ResponseDtos.IssueBookResponseDto;
import com.example.LibraryManagementSystem.Services.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{
        Transaction transaction=new Transaction();
        transaction.setTransactionNo(String.valueOf(UUID.randomUUID()));
        transaction.setIssued(true);
        //check for card validation
        Card card;
        try{
            card=cardRepository.findById(issueBookRequestDto.getCardid()).get();
        }catch(Exception e)
        {
            //if exception occurs then we are saving failed transaction and throwing exception
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card does not exist");
        }
        //checking card status and expiry date
        if(card.getStatus()!= Status.ACTIVATED) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("card is not in active state");
        }
        if(card.getExpiryDate().compareTo(new Date())<0) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("card got expired");
        }

        transaction.setCard(card);

        //check for book validation
        Book book;
        try{
            book=bookRepository.findById(issueBookRequestDto.getBookid()).get();
        }catch (Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("book does not exist");
        }
        //if book exist then check is issued or not
        boolean bool=book.isIssued();
        if(bool)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("book is not available for issue");
        }
        transaction.setBook(book);
        //if book and card is ok to issue
        //then mark transaction as success and store into the db
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        //before sending response alter all necessary modifications in all related entities
        book.setIssued(true);
        book.setCard(card);
        book.getTransactions().add(transaction);

        card.getTransactions().add(transaction);
        card.getBooks().add(book);

        cardRepository.save(card);//it will save all card,book,transactions all together
        //since it is a parent for books and transactions relation

        IssueBookResponseDto response=new IssueBookResponseDto();
        response.setTransactionNo(transaction.getTransactionNo());
        response.setTransactionStatus(transaction.getTransactionStatus());
        response.setBookName(transaction.getBook().getTitle());

        //sending mails through this block of code
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplyaryan999@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Issue book");
        message.setText("Dear "+card.getStudent().getName()+" book with title "+book.getTitle()+" has been issued to you");
        emailSender.send(message);
        return response;
    }
    //return book api
    @Override
    public IssueBookResponseDto returnBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transaction transaction=new Transaction();
        transaction.setTransactionNo(String.valueOf(UUID.randomUUID()));
        transaction.setIssued(false);//means returning
        //check for card validation
        Card card;
        try{
            card=cardRepository.findById(issueBookRequestDto.getCardid()).get();
        }catch(Exception e)
        {
            //if exception occurs then we are saving failed transaction and throwing exception
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card does not exist");
        }
        //checking card status and expiry date
        if(card.getStatus()!= Status.ACTIVATED) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("card is not in active state");
        }
        if(card.getExpiryDate().compareTo(new Date())<0) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("card got expired");
        }

        transaction.setCard(card);

        //check for book validation
        Book book;
        try{
            book=bookRepository.findById(issueBookRequestDto.getBookid()).get();
        }catch (Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("book does not exist");
        }
        //if book exist then check is issued or not
        boolean bool=book.isIssued();
        if(!bool)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("book is not issued");
        }
        transaction.setBook(book);
        //if book and card is ok to return
        //then mark transaction as success and store into the db
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        //before sending response alter all necessary modifications in all related entities
        book.setIssued(false);
        book.setCard(null);
        book.getTransactions().add(transaction);

        card.getTransactions().add(transaction);
        card.getBooks().remove(book);

        cardRepository.save(card);//it will save all card,book,transactions all together
        //since it is a parent for books and transactions relation

        IssueBookResponseDto response=new IssueBookResponseDto();
        response.setTransactionNo(transaction.getTransactionNo());
        response.setTransactionStatus(transaction.getTransactionStatus());
        response.setBookName(transaction.getBook().getTitle());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplyaryan999@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Returned book");
        message.setText("Dear "+card.getStudent().getName()+", book with title "+book.getTitle()+" has been returned by you, Thank you!");
        emailSender.send(message);
        return response;
    }


}

package com.guojc.bean.tx.anno.service;

import com.guojc.bean.tx.anno.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookService2 {

    @Autowired
    BookDao bookDao;


//	@Autowired
//	BookService bookService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void checkout(String username, String isbn) {
        //1、减库存
        bookDao.updateStock(isbn);

        int price = bookDao.getPrice(isbn);

        //2、减余额
        bookDao.updateBalance(username, price);

        //int i = 10/0;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePrice(String isbn, int price) {
        bookDao.updatePrice(isbn, price);
    }


    @Transactional(readOnly = true)
    public int getPrice(String isbn) {
        return bookDao.getPrice(isbn);
    }


    @Transactional
    public void mulTx() {
        //ioc.getBean("BookSerice");
        checkout("Tom", "ISBN-001");
        updatePrice("ISBN-002", 998);
        int i = 10 / 0;
    }
}

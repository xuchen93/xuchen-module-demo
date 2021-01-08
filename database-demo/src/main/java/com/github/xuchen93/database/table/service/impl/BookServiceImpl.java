package com.github.xuchen93.database.table.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.xuchen93.database.table.dao.BookDao;
import com.github.xuchen93.database.table.entity.Book;
import com.github.xuchen93.database.table.service.BookService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuchen
 * @since 2020-10-10
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

}

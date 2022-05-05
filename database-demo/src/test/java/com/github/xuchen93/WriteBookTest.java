package com.github.xuchen93;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xuchen93.database.table.entity.Book;
import com.github.xuchen93.database.table.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class WriteBookTest {

	int length = 30;
	@Autowired
	BookService service;

	@Test
	void contextLoads() {
		List<String> lines = FileUtil.readLines("file", CharsetUtil.GBK);
		List<Book> list = new ArrayList<>();
		int c =0;
		log.info("合计{}行",lines.size());
		for (String line : lines) {
			log.info("处理第{}行",c++);
			String[] strings = StrUtil.split(line, length);
			for (String content : strings) {
				list.add(buildEntity(content));
			}
		}
		list = list.stream().filter(item -> StrUtil.isNotBlank(item.getContent())).collect(Collectors.toList());
		List<List<Book>> dbList = CollUtil.split(list, 100);
		log.info("合计入库{}次",dbList.size());
		for (int i = 0; i < dbList.size(); i++) {
			log.info("入库第{}次",i);
			service.saveBatch(dbList.get(i));
		}
	}

	private Book buildEntity(String content) {
		Book e = new Book();
		e.setContent(content);
		e.setType(0);
		return e;
	}

}

package com.github.xuchen93;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xuchen93.database.table.entity.Book;
import com.github.xuchen93.database.table.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class WriteBookTest {

	int length = 30;
	@Autowired
	BookService service;

	@Test
	void contextLoads() {
		List<String> lines = FileUtil.readLines("F:\\chromeDownload\\拔魔.txt", CharsetUtil.GBK);
		List<Book> list = new ArrayList<>();
		for (String line : lines) {
			String s;
			while (line.length() > length)
				list.add(buildEntity(line));
		}
		list = list.stream().filter(item -> StrUtil.isNotBlank(item.getContent())).collect(Collectors.toList());
		while (!list.isEmpty()) {
			System.out.println(list.size());
			int count;
			if (list.size() > 100) {
				count = 100;
			} else {
				count = list.size();
			}
			service.saveBatch(list.subList(0, count));
			list = list.subList(count, list.size());
		}
	}

	private Book buildEntity(String content) {
		Book e = new Book();
		e.setContent(content);
		e.setType(0);
		return e;
	}

}

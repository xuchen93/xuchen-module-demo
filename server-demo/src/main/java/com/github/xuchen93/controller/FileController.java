package com.github.xuchen93.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.github.xuchen93.model.R;
import com.github.xuchen93.model.ex.BusiException;
import com.github.xuchen93.web.controller.BaseController;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author edwin
 */
@Slf4j
@RestController
public class FileController extends BaseController {

	@PostMapping("excel")
	public void excel(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()){
			throw new BusiException("缺少文件");
		}
		ExcelReader reader = null;
		ExcelWriter writer = null;
		try {
			reader = ExcelUtil.getReader(file.getInputStream());
			List<List<Object>> list = reader.read();
			int length = list.get(0).size();
			writer = reader.getWriter();
			for (int i = 0; i < list.size(); i++) {
				log.info(JSONUtil.toJsonStr(list.get(i)));
				if (i==3){
					writer.writeCellValue(length,i,"失败");
				} else {
					writer.writeCellValue(length,i,"成功");
				}
			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("处理后的文件.xlsx", "UTF-8"));
			writer.flush(response.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IoUtil.close(reader);
			IoUtil.close(writer);
		}
	}

	@SneakyThrows
	@GetMapping("getExcel")
	public void getExcel(){
		File file = FileUtil.file("F://1.xlsx");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-download");
		response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("处理后的文件.xlsx", "UTF-8"));
		ServletOutputStream outputStream = response.getOutputStream();
		FileUtil.writeToStream(file,outputStream);
	}
}

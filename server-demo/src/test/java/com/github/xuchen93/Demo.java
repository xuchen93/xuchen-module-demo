package com.github.xuchen93;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author edwin
 */
@Slf4j
public class Demo {

    @SneakyThrows
    public static void main(String[] args) {
		String dir = "D:\\";
//		String fileName = dir+"云二话术产品表-已更新.xlsx";
//		String fileName = dir+"云三话术产品表(2).xlsx";
		String fileName = dir+"云一话术产品表.xlsx";
		File file = FileUtil.file(fileName);
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		ExcelReader reader = ExcelUtil.getReader(file);
		List<List<Object>> read = reader.read(1);
		int count = 0;
		Map<Integer,String> map = new HashMap<>();
		for (List<Object> objects : read) {
			if (objects != null && objects.size() == 4 && NumberUtil.isNumber(String.valueOf(objects.get(2)))){
				map.put(Integer.valueOf(String.valueOf(objects.get(2))), String.valueOf(objects.get(3)));
				count++;
				soutSql(objects.get(0).toString(), objects.get(2).toString(), objects.get(3).toString());
			} else {
//				System.out.println("==="+JSONUtil.toJsonStr(objects));
			}
		}
		System.out.println(count);
		System.out.println(map);

	}

	private static void soutSql(String id,String productId,String productName){
		System.out.println(StrUtil.format("update crm_template set template_product_id = {},template_product_name = '{}' where id = {};"
				,productId,productName.trim(),id));
	}

    @Data
    private static class Info {
        private String id;
        private String name;
        private String productId;
        private String productName;
    }
}

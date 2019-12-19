package com.webtest.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.testng.ITestResult;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Freemarker {
	private static final String TEMPLATE_PATH = "templates";
	private static final String CLASS_PATH = "E:";

	public static String getFreemarker(String now, int count, int failCount, Set<ITestResult> trSuccess) {
		// 创建配置类
		Configuration configuration = new Configuration();
		StringWriter out = new StringWriter();
		try {
			// 设置模板所在的目录
			configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
			// 创建数据模型
			Map<String, Object> dataMap = new HashMap<String, Object>();
			for (int i = 0; i < trSuccess.size(); i++) {
				dataMap.put("name" + i, trSuccess.toString());
			}
			dataMap.put("now", now);
			dataMap.put("count", count);
			dataMap.put("failCount", failCount);
			// 设置字符集
			configuration.setDefaultEncoding("utf-8");
			// 加载模板
			Template template = configuration.getTemplate("hello.ftl");
			// 存入输出流中
			template.process(dataMap, out);

			return out.toString();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (null != out) {
					out.flush();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}

<html>
<head>
	<meta charset=utf-8>
	<title>Welcome!</title>
</head>
<body>
	<p>自动化测试报告-----${now}</p>
	<p>本次共运行测试case:${count}个,其中FAIL:${failCount}个</p>
	<table border="1">
		<tr bgcolor="green">
			<th colspan="4" align="left">以下case执行成功</th>
		</tr>
		<tr bgcolor="yellow">
			<td align="center">序号</td>
			<td align="center">test method</td>
			<td>case title</td>
			<td>测试结论</td>
		</tr>
		<#assign  index = 0 >
		<#list name as rename>
		<#assign index = index+1> 
			<tr bgcolor="yellow">
				<td align="center">${index}</td>
				<td align="center">${rename}</td>
				<td></td>
				<td>PASS</td>
			</tr>
		</#list>
	</table>
</body>
</html>
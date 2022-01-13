<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>小呆 - 数据面板</title>
		<link rel="stylesheet" href="./assets/css/login.css">
		<script src="./assets/js/vue.global.js"></script>
		<!-- import CSS -->
		<link rel="stylesheet" href="./assets/css/index.css">
		<!-- import ElementPlus JavaScript -->
		<script src="./assets/js/index.full.js"></script>
		<!--echarts-->
		<script src="./assets/js/echarts.min.js"></script>
		<style>
			* {
				padding: 0;
				margin: 0;
			}

			#panel {
				width: 100%;
				height: 100vh;
			}

			.black-el-header {
				background-color: black;
				height: 8.5vh;
				color: var(--el-text-color-primary);
				text-align: center;
				line-height: 8.5vh;
				color: white;
			}

			.el-aside {
				background-color: black;
				color: var(--el-text-color-primary);
				text-align: center;
			}

			.el-main,
			.el-footer {
				background-color: #e9eef3;
				color: var(--el-text-color-primary);
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div id="panel">
			<el-container style="width:100%;height: 100%;">
				<el-header class="black-el-header">
					<el-row>
						<el-col :span="3">
							小呆生成器
						</el-col>
						<el-col :span="2" :offset="19">
							<el-dropdown>
								<span v-if="userDao != null && userDao != undefined">{{userDao.uName}}</span>
								<span v-if="userDao == null || userDao == undefined">小呆</span>
								<template #dropdown>
									<el-dropdown-menu>
										<el-dropdown-item>个人信息</el-dropdown-item>
										<el-dropdown-item>GitHub</el-dropdown-item>
										<el-dropdown-item>退出</el-dropdown-item>
									</el-dropdown-menu>
								</template>
							</el-dropdown>
						</el-col>
					</el-row>
				</el-header>
				<el-container style="width: 100%;height: 90vh;">
					<el-aside width="15%">
						<el-menu active-text-color="#ffd04b" background-color="black" class="el-menu-vertical-demo"
							 text-color="#fff" >
							<el-menu-item index="1">
								<span style="display: inline-block;width: 100%;height: 100%;text-align: center"><a style="display: inline-block;width: 100%;height: 100%;color: white" href="./panel.html" style="color: white;">数据面板</a></span>
							</el-menu-item>
							<#assign n=1>
							<#list daoList as list><#assign n++>
								<el-menu-item index="${n}">
									<span style="display: inline-block;width: 100%;height: 100%;text-align: center"><a style="display: inline-block;width: 100%;height: 100%;color: white" href="./${list.dealingTableName?uncap_first}Manager.html" style="color: white;">${list.comment}管理</a></span>
								</el-menu-item>
							</#list>
						</el-menu>
					</el-aside>
					<el-container>
						<el-main>
							<el-row :gutter="20">
								<el-col :span="6">
									<el-card shadow="hover">
										<div class="information-box">
											<el-row>
												<el-col :span="12" :offset="1">
													<h4>
														<el-icon>
															<svg t="1640919492748" class="icon" viewBox="0 0 1024 1024"
																version="1.1" xmlns="http://www.w3.org/2000/svg"
																p-id="1850" width="200" height="200">
																<path
																	d="M512 716.8c-105.198933 0-191.146667-85.947733-191.146667-191.146667s85.947733-191.146667 191.146667-191.146666 191.146667 85.947733 191.146667 191.146666S617.198933 716.8 512 716.8z m0-54.613333c75.025067 0 136.533333-61.508267 136.533333-136.533334s-61.508267-136.533333-136.533333-136.533333-136.533333 61.508267-136.533333 136.533333 61.508267 136.533333 136.533333 136.533334z m0 218.453333c-178.688 0-315.050667-116.872533-407.586133-344.712533a27.306667 27.306667 0 0 1 0-20.548267C196.9152 287.5392 333.312 170.666667 512 170.666667s315.050667 116.872533 407.586133 344.712533a27.306667 27.306667 0 0 1 0 20.548267C827.0848 763.767467 690.688 880.64 512 880.64z m0-54.613333c151.04 0 268.151467-98.235733 352.768-300.373334-84.650667-202.1376-201.728-300.373333-352.768-300.373333-151.04 0-268.151467 98.235733-352.768 300.373333 84.650667 202.1376 201.728 300.373333 352.768 300.373334z"
																	p-id="1851"></path>
															</svg>
														</el-icon>
														总浏览量
													</h4>
												</el-col>
												<el-col :span="8" :offset="1">
													<h3>
														32765
													</h3>
												</el-col>
											</el-row>
										</div>
									</el-card>
								</el-col>
								<el-col :span="6">
									<el-card shadow="hover">
										<div class="information-box">
											<el-row>
												<el-col :span="12" :offset="1">
													<h4>
														<el-icon>
															<svg t="1640919797277" class="icon" viewBox="0 0 1024 1024"
																version="1.1" xmlns="http://www.w3.org/2000/svg"
																p-id="2704" width="200" height="200">
																<path
																	d="M896 896H96a32 32 0 0 1-32-32V224a32 32 0 0 1 64 0v608h768a32 32 0 1 1 0 64z"
																	p-id="2705"></path>
																<path
																	d="M512 752.16a32 32 0 0 1-32-32V350.624a32 32 0 0 1 64 0v369.536a32 32 0 0 1-32 32zM320 752.576a32 32 0 0 1-32-32V512a32 32 0 0 1 64 0v208.576a32 32 0 0 1-32 32zM896 752.672a32 32 0 0 1-32-32V163.488a32 32 0 1 1 64 0v557.184a32 32 0 0 1-32 32zM704 752.736a32 32 0 0 1-32-32V224a32 32 0 1 1 64 0v496.736a32 32 0 0 1-32 32z"
																	p-id="2706"></path>
															</svg>
														</el-icon>
														今日浏览量
													</h4>
												</el-col>
												<el-col :span="8" :offset="1">
													<h3>
														233
													</h3>
												</el-col>
											</el-row>
										</div>
									</el-card>
								</el-col>
								<el-col :span="6">
									<el-card shadow="hover">
										<div class="information-box">
											<el-row>
												<el-col :span="12" :offset="1">
													<h4>
														<el-icon>
															<svg t="1640919921343" class="icon" viewBox="0 0 1024 1024"
																version="1.1" xmlns="http://www.w3.org/2000/svg"
																p-id="4826" width="200" height="200">
																<path
																	d="M490.666667 981.333333a440.906667 440.906667 0 0 1-173.773334-35.46 453.766667 453.766667 0 0 1-238.766666-238.766666 443.52 443.52 0 0 1 0-347.546667 453.766667 453.766667 0 0 1 238.766666-238.766667A440.906667 440.906667 0 0 1 490.666667 85.333333a21.333333 21.333333 0 0 1 21.333333 21.333334v405.333333h405.333333a21.333333 21.333333 0 0 1 21.333334 21.333333 440.906667 440.906667 0 0 1-35.46 173.773334 453.766667 453.766667 0 0 1-238.766667 238.766666A440.906667 440.906667 0 0 1 490.666667 981.333333zM469.333333 128.553333C255.72 139.693333 85.333333 316.993333 85.333333 533.333333c0 223.5 181.833333 405.333333 405.333334 405.333334 216.34 0 393.64-170.386667 404.78-384H490.666667a21.333333 21.333333 0 0 1-21.333334-21.333334zM960 469.333333H576a21.333333 21.333333 0 0 1-21.333333-21.333333V64a21.333333 21.333333 0 0 1 21.333333-21.333333 405.373333 405.373333 0 0 1 405.333333 405.333333 21.333333 21.333333 0 0 1-21.333333 21.333333z m-362.666667-42.666666h340.666667c-5.333333-87.94-43.113333-172.666667-105.58-235.113334S685.273333 91.273333 597.333333 86z"
																	fill="#5C5C66" p-id="4827"></path>
															</svg>
														</el-icon>
														用户数
													</h4>
												</el-col>
												<el-col :span="8" :offset="1">
													<h3>
														322
													</h3>
												</el-col>
											</el-row>
										</div>
									</el-card>
								</el-col>
								<el-col :span="6">
									<el-card shadow="hover">
										<div class="information-box">
											<el-row>
												<el-col :span="12" :offset="1">
													<h4>
														<el-icon>
															<svg t="1640919907622" class="icon" viewBox="0 0 1024 1024"
																version="1.1" xmlns="http://www.w3.org/2000/svg"
																p-id="3973" width="200" height="200">
																<path
																	d="M843.875 135.125h-90V90.125c0-11.25-16.875-28.125-33.75-28.125s-28.125 11.25-28.125 28.125v39.375H360.125V90.125c0-11.25-11.25-28.125-28.125-28.125s-28.125 16.875-28.125 28.125v39.375H180.125C129.5 135.125 90.125 174.5 90.125 219.5v652.5c0 50.625 39.375 90 90 90h663.75c50.625 0 90-39.375 90-90V219.5c0-45-39.375-84.375-90-84.375z m28.125 736.875c0 16.875-11.25 28.125-28.125 28.125H180.125c-16.875 0-28.125-11.25-28.125-28.125V219.5c0-16.875 11.25-28.125 28.125-28.125h118.125v5.625c5.625 16.875 16.875 33.75 33.75 33.75s28.125-11.25 28.125-28.125v-11.25h331.875v5.625c0 16.875 11.25 28.125 28.125 28.125s28.125-11.25 28.125-28.125v-5.625h90c16.875 0 28.125 11.25 28.125 28.125v652.5z"
																	p-id="3974"></path>
																<path
																	d="M753.875 337.625H270.125c-16.875 0-28.125 11.25-28.125 28.125s11.25 33.75 28.125 33.75h483.75c16.875 0 28.125-11.25 28.125-28.125s-11.25-33.75-28.125-33.75zM753.875 517.625H270.125c-16.875 0-28.125 11.25-28.125 28.125s11.25 28.125 28.125 28.125h483.75c16.875 0 28.125-11.25 28.125-28.125s-11.25-28.125-28.125-28.125zM512 697.625H270.125c-16.875 0-28.125 11.25-28.125 28.125s11.25 28.125 28.125 28.125H512c16.875 0 28.125-11.25 28.125-28.125s-11.25-28.125-28.125-28.125z"
																	p-id="3975"></path>
															</svg>
														</el-icon>
														运行日志
													</h4>
												</el-col>
												<el-col :span="8" :offset="1">
													<h3>
														12678
													</h3>
												</el-col>
											</el-row>
										</div>
									</el-card>
								</el-col>
							</el-row>
							<br>
							<el-row :gutter="20">
								<el-col :span="12">
									<el-card shadow="hover">
										<div id="bar" class="echarts-box"></div>
									</el-card>
								</el-col>
								<el-col :span="12">
									<el-card shadow="hover">
										<div class="echarts-box" id="polyline"></div>
									</el-card>
								</el-col>
							</el-row>
							<br>
							<el-row>
								<el-col :span="24">
									<el-card>
										<div style="width: 100%;height: 400px;" id="main"></div>
									</el-card>
								</el-col>
							</el-row>
						</el-main>
						<el-footer style="height: 3vh;">
							Copyright © 2021 <a
								href="https://github.com/xing-yu-chen/small-dai-open-source">small-dai-open-source</a>.
							All rights reserved.
						</el-footer>
					</el-container>
				</el-container>
			</el-container>
		</div>
	</body>
	<script src="./assets/js/axios.min.js"></script>
	<script>
		const {
			createApp
		} = Vue;


		//基础路径
		var baseUrl = "http://localhost/v1";

		const app = createApp({
			data: function() {
				return {
					userDao: JSON.parse(window.localStorage.getItem("userMsg")),
					barOption: {
						title: {
							text: '柱状图'
						},
						tooltip: {
							trigger: 'axis'
						},
						legend: {
							data: ['友链', '转发', '广告', '直接访问', '搜索引擎']
						},
						xAxis: {
							type: 'category',
							data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
						},
						yAxis: {
							type: 'value'
						},
						series: [{
								name: '友链',
								type: 'bar',
								data: [120, 132, 101, 134, 90, 230, 210]
							},
							{
								name: '转发',
								type: 'bar',
								data: [220, 182, 191, 234, 290, 330, 310]
							},
							{
								name: '广告',
								type: 'bar',
								data: [150, 232, 201, 154, 190, 330, 410]
							},
							{
								name: '直接访问',
								type: 'bar',
								data: [320, 332, 301, 334, 390, 330, 320]
							},
							{
								name: '搜索引擎',
								type: 'bar',
								data: [820, 932, 901, 934, 1290, 1330, 1320]
							}
						]
					},
					lineOption: {
						title: {
							text: '折线图'
						},
						tooltip: {
							trigger: 'axis'
						},
						legend: {
							data: ['友链', '转发', '广告', '直接访问', '搜索引擎']
						},
						grid: {
							left: '3%',
							right: '4%',
							bottom: '3%',
							containLabel: true
						},
						xAxis: {
							type: 'category',
							boundaryGap: false,
							data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
						},
						yAxis: {
							type: 'value'
						},
						series: [{
								name: '友链',
								type: 'line',
								data: [120, 132, 101, 134, 90, 230, 210]
							},
							{
								name: '转发',
								type: 'line',
								data: [220, 182, 191, 234, 290, 330, 310]
							},
							{
								name: '广告',
								type: 'line',
								data: [150, 232, 201, 154, 190, 330, 410]
							},
							{
								name: '直接访问',
								type: 'line',
								data: [320, 332, 301, 334, 390, 330, 320]
							},
							{
								name: '搜索引擎',
								type: 'line',
								data: [820, 932, 901, 934, 1290, 1330, 1320]
							}
						]
					},
					pieOption: {
						series: [{
							type: 'pie',
							data: [{
									name: "淘宝",
									value: 11231
								},
								{
									name: "京东",
									value: 22673
								},
								{
									name: "唯品会",
									value: 6123
								},
								{
									name: "1号店",
									value: 8989
								},
								{
									name: "聚美优品",
									value: 6700
								}
							]
						}]
					}
				}
			},
			methods: {

			},
			mounted() {
				// 基于准备好的dom，初始化echarts实例
				let barChart = echarts.init(document.getElementById('bar'));
				// 使用刚指定的配置项和数据显示图表。
				barChart.setOption(this.barOption);
				// 基于准备好的dom，初始化echarts实例
				let lineChart = echarts.init(document.getElementById('polyline'));
				// 使用刚指定的配置项和数据显示图表。
				lineChart.setOption(this.lineOption);
				// 基于准备好的dom，初始化echarts实例
				let mainChart = echarts.init(document.getElementById('main'));
				// 使用刚指定的配置项和数据显示图表。
				mainChart.setOption(this.pieOption);
			}
		})
		app.use(ElementPlus)
		app.mount("#panel")
	</script>
</html>

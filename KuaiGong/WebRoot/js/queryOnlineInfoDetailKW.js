$(function() {
	queryOnlineDetailInfo();
	queryNearlyAWeekDetailInfo();
	queryNearlyAWeekWorkDetailInfo();
//	 test();
});

function queryOnlineDetailInfo(){
	 // 基于准备好的dom，初始化echarts实例
	var id = $("#eeid").val();
    var myChart = echarts.init(document.getElementById('first'));
    var myChartSecond = echarts.init(document.getElementById('second'));
   

    // 使用刚指定的配置项和数据显示图表。
	$.post("onlineInformation/queryOnlineDetailInfo.action",{eeid:id},
			function(data) {
		console.log("总"+data.totalTime);
		console.log("年"+data.yearTime);
		console.log("月"+data.monthTime);
		console.log("周"+data.weekTime);
		 // 指定图表的配置项和数据
	    var option = {
			title : {
			    text: '某站点用户访问来源',
			    subtext: '纯属虚构',
			    x:'center'
			},
			tooltip : {
			    trigger: 'item',
			    formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			legend: {
			    orient: 'vertical',
			    left: 'left',
			    data: ['总在线','年在线','月在线','周在线']
			},
			series : [
			    {
			        name: '访问来源',
			        type: 'pie',
			        radius : '55%',
			        center: ['50%', '60%'],
			        data:[
			              {value:data.totalTime, name:'总在线'},
			               {value:data.yearTime, name:'年在线'},
			               {value:data.monthTime, name:'月在线'},
			               {value:data.weekTime, name:'周在线'}
			        ],
			        itemStyle: {
			            emphasis: {
			                shadowBlur: 10,
			                shadowOffsetX: 0,
			                shadowColor: 'rgba(0, 0, 0, 0.5)'
			            }
			        }
			    }
			]
			};
	    
	    var optionSecond = {
				title : {
				    text: '某站点用户访问来源',
				    subtext: '纯属虚构',
				    x:'center'
				},
				tooltip : {
				    trigger: 'item',
				    formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				legend: {
				    orient: 'vertical',
				    left: 'left',
				    data: ['总工作时长','年工作时长','月工作时长','周工作时长']
				},
				series : [
				    {
				        name: '访问来源',
				        type: 'pie',
				        radius : '55%',
				        center: ['50%', '60%'],
				        data:[
				              {value:data.totalWorkTime, name:'总工作时长'},
				               {value:data.yearWorkTime, name:'年工作时长'},
				               {value:data.monthWorkTime, name:'月工作时长'},
				               {value:data.weekWorkTime, name:'周工作时长'}
				        ],
				        itemStyle: {
				            emphasis: {
				                shadowBlur: 10,
				                shadowOffsetX: 0,
				                shadowColor: 'rgba(0, 0, 0, 0.5)'
				            }
				        }
				    }
				]
				};
	    
	    
	    
			myChart.setOption(option);
			myChartSecond.setOption(optionSecond);
			}, "json");
    
}

function queryNearlyAWeekDetailInfo(){
	 //queryNearlyAWeekOnlineDetailInfo   online
	 var id = $("#eeid").val();
	 var dateStr = test();
	 var dateTime = new Array();
	 	dateTime[0] = 0;
		dateTime[1] = 0;
		dateTime[2] = 0;
		dateTime[3] = 0;
		dateTime[4] = 0;
		dateTime[5] = 0;
		dateTime[6] = 0;
	$.post("onlineInformation/queryNearlyAWeekOnlineDetailInfo.action",{eeid:id},
			function(data) {
		if(data!="null"){
			$.each(data, function() {
				var i = 0;
				var start = this.startime;
				var end = this.endtime;
				if(compareDate(this.startime, dateStr[0])){
					// compareDate是 str1<=str2 返回true
					//DateDiff (大，小)
					
					
					if(compareDate(dateStr[0],start)){
						
					}else{
						start = dateStr[0];
					}
					
					//当endtime=startime是才返回true
					if(compareDate(end,start)){
						dateTime[0] = dateTime[0] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[1])){
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + DateDiff(end,dateStr[1]);
//						console.log("two"+DateDiff(dateStr[1],start));
//						console.log("two"+DateDiff(end,dateStr[1]));
					}else if(compareDate(end,dateStr[2])){
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] +DateDiff(end,dateStr[2]);
//						console.log("three"+DateDiff(dateStr[1],start));
//						console.log("three 24小时");
//						console.log("three"+DateDiff(end,dateStr[2]));
					}else if(compareDate(end,dateStr[3])){
						
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + DateDiff(end,dateStr[3]);
//						console.log("four"+DateDiff(dateStr[1],start));
//						console.log("four 24小时");
//						console.log("four 24小时");
//						console.log("four"+DateDiff(end,dateStr[3]));
					}else if(compareDate(end,dateStr[4])){
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + DateDiff(end,dateStr[4]);
//						console.log("five"+DateDiff(dateStr[1],start));
//						console.log("five 24小时");
//						console.log("five 24小时");
//						console.log("five 24小时");
//						console.log("five"+DateDiff(end,dateStr[4]));
					}else if(compareDate(end,dateStr[5])){
						
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
//						console.log("six"+DateDiff(dateStr[1],start));
//						console.log("six 24小时");
//						console.log("six 24小时");
//						console.log("six 24小时");
//						console.log("six 24小时");
//						console.log("six"+DateDiff(end,dateStr[5]));
					}else if(compareDate(end,dateStr[6])){
						
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
						console.log(DateDiff(dateStr[2],dateStr[1]));
						
						
						
//						console.log("seven"+DateDiff(dateStr[1],start));
//						console.log("seven 24小时");
//						console.log("seven 24小时");
//						console.log("seven 24小时");
//						console.log("seven 24小时");
//						console.log("seven 24小时");
//						console.log("seven"+DateDiff(end,dateStr[6]));
					}
				}else if(compareDate(this.startime, dateStr[1])){
					if(compareDate(end,start)){
						dateTime[1] = dateTime[1] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[2])){
						dateTime[1] = dateTime[1] + DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + DateDiff(end,dateStr[2]);
					}else if(compareDate(end,dateStr[3])){
						dateTime[1] = dateTime[1] + DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + DateDiff(end,dateStr[3]);
					}else if(compareDate(end,dateStr[4])){
						dateTime[1] = dateTime[1] +DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] +86400;
						dateTime[4] = dateTime[4] + DateDiff(end,dateStr[4]);
					}else if(compareDate(end,dateStr[5])){
						dateTime[1] = dateTime[1] +DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] +86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
					}else if(compareDate(end,dateStr[6])){
						
						dateTime[1] = dateTime[1] + DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
					}
				}else if(compareDate(this.startime, dateStr[2])){
					if(compareDate(end,start)){
						dateTime[2] = dateTime[2] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[3])){
						dateTime[2] = dateTime[2] + DateDiff(dateStr[3],start);
						dateTime[3] = dateTime[3] + DateDiff(end,dateStr[3]);
					}else if(compareDate(end,dateStr[4])){
						dateTime[2] = dateTime[2] + DateDiff(dateStr[3],start);
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + DateDiff(end,dateStr[4]);
					}else if(compareDate(end,dateStr[5])){
						dateTime[2] = dateTime[2] + DateDiff(dateStr[3],start);
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
					}else if(compareDate(end,dateStr[6])){
						dateTime[2] = dateTime[2] + DateDiff(dateStr[3],start);
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);;
					}
				}else if(compareDate(this.startime, dateStr[3])){
					if(compareDate(end,start)){
						dateTime[3] = dateTime[3] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[4])){
						dateTime[3] = dateTime[3] + DateDiff(dateStr[4],start);
						dateTime[4] = dateTime[4] + DateDiff(end,dateStr[4]);
					}else if(compareDate(end,dateStr[5])){
						dateTime[3] = dateTime[3] + DateDiff(dateStr[4],start);
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
					}else if(compareDate(end,dateStr[6])){
						dateTime[3] = dateTime[3] + DateDiff(dateStr[4],start);
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
					}
				}else if(compareDate(this.startime, dateStr[4])){
					if(compareDate(end,start)){
						dateTime[4] = dateTime[4] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[5])){
						dateTime[4] = dateTime[4] + DateDiff(dateStr[5],start);
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
					}else if(compareDate(end,dateStr[6])){
						dateTime[4] = dateTime[4] + DateDiff(dateStr[5],start);
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
					}
				}else if(compareDate(this.startime, dateStr[5])){
					if(compareDate(end,start)){
						dateTime[5] = dateTime[5] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[6])){
						dateTime[5] = dateTime[5] + DateDiff(dateStr[6],start);
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
					}
				}
				else if(compareDate(this.startime, dateStr[6])){
					if(compareDate(end,start)){
						dateTime[6] = dateTime[6] + DateDiff(end,start);
					}
				}
				
				
				
			});
		}
		
		// ========= 折线图
		var myChartThree = echarts.init(document.getElementById('third'));

        // 指定图表的配置项和数据
       var colors = ['#5793f3', '#d14a61', '#675bba'];
optionThree = {
    color: colors,
    tooltip: {
        trigger: 'none',
        axisPointer: {
            type: 'cross'
        }
    },
    legend: {
        data: ['2016 降水量']
    },
    grid: {
        top: 70,
        bottom: 50
    },
    xAxis: [
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[1]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '降水量  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: [dateStr[0],dateStr[1],dateStr[2],dateStr[3],dateStr[4],dateStr[5],dateStr[6]]
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name:'2016 降水量',
            type:'line',
            smooth: true,
            data: [dateTime[0]/3600,dateTime[1]/3600 , dateTime[2]/3600, dateTime[3]/3600, dateTime[4]/3600, dateTime[5]/3600, dateTime[6]/3600]
        }
    ]
};

        // 使用刚指定的配置项和数据显示图表。
myChartThree.setOption(optionThree);
		
	}, "json");
    
}
//work nearly a week 
function queryNearlyAWeekWorkDetailInfo(){
	 //queryNearlyAWeekWorkDetailInfo   work
	 var id = $("#eeid").val();
	 var dateStr = test();
	 var dateTime = new Array();
	 	dateTime[0] = 0;
		dateTime[1] = 0;
		dateTime[2] = 0;
		dateTime[3] = 0;
		dateTime[4] = 0;
		dateTime[5] = 0;
		dateTime[6] = 0;
	$.post("onlineInformation/queryNearlyAWeekWorkDetailInfo.action",{eeid:id},
			function(data) {
		if(data!="null"){
			$.each(data, function() {
				var i = 0;
				var start = this.startime;
				var end = this.endtime;
				if(compareDate(this.startime, dateStr[0])){
					// compareDate是 str1<=str2 返回true
					//DateDiff (大，小)
					
					if(compareDate(dateStr[0],start)){
						
					}else{
						start = dateStr[0];
					}
					//当endtime=startime是才返回true
					if(compareDate(end,start)){
						dateTime[0] = dateTime[0] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[1])){
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + DateDiff(end,dateStr[1]);
//						console.log("two"+DateDiff(dateStr[1],start));
//						console.log("two"+DateDiff(end,dateStr[1]));
					}else if(compareDate(end,dateStr[2])){
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] +DateDiff(end,dateStr[2]);
//						console.log("three"+DateDiff(dateStr[1],start));
//						console.log("three 24小时");
//						console.log("three"+DateDiff(end,dateStr[2]));
					}else if(compareDate(end,dateStr[3])){
						
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + DateDiff(end,dateStr[3]);
//						console.log("four"+DateDiff(dateStr[1],start));
//						console.log("four 24小时");
//						console.log("four 24小时");
//						console.log("four"+DateDiff(end,dateStr[3]));
					}else if(compareDate(end,dateStr[4])){
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + DateDiff(end,dateStr[4]);
//						console.log("five"+DateDiff(dateStr[1],start));
//						console.log("five 24小时");
//						console.log("five 24小时");
//						console.log("five 24小时");
//						console.log("five"+DateDiff(end,dateStr[4]));
					}else if(compareDate(end,dateStr[5])){
						
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
//						console.log("six"+DateDiff(dateStr[1],start));
//						console.log("six 24小时");
//						console.log("six 24小时");
//						console.log("six 24小时");
//						console.log("six 24小时");
//						console.log("six"+DateDiff(end,dateStr[5]));
					}else if(compareDate(end,dateStr[6])){
						
						dateTime[0] = dateTime[0] + DateDiff(dateStr[1],start);
						dateTime[1] = dateTime[1] + 86400;
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
						
						
						
//						console.log("seven"+DateDiff(dateStr[1],start));
//						console.log("seven 24小时");
//						console.log("seven 24小时");
//						console.log("seven 24小时");
//						console.log("seven 24小时");
//						console.log("seven 24小时");
//						console.log("seven"+DateDiff(end,dateStr[6]));
					}
				}else if(compareDate(this.startime, dateStr[1])){
					if(compareDate(end,start)){
						dateTime[1] = dateTime[1] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[2])){
						dateTime[1] = dateTime[1] + DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + DateDiff(end,dateStr[2]);
					}else if(compareDate(end,dateStr[3])){
						dateTime[1] = dateTime[1] + DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + DateDiff(end,dateStr[3]);
					}else if(compareDate(end,dateStr[4])){
						dateTime[1] = dateTime[1] +DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] +86400;
						dateTime[4] = dateTime[4] + DateDiff(end,dateStr[4]);
					}else if(compareDate(end,dateStr[5])){
						dateTime[1] = dateTime[1] +DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] +86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
					}else if(compareDate(end,dateStr[6])){
						
						dateTime[1] = dateTime[1] + DateDiff(dateStr[2],start);
						dateTime[2] = dateTime[2] + 86400;
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
					}
				}else if(compareDate(this.startime, dateStr[2])){
					if(compareDate(end,start)){
						dateTime[2] = dateTime[2] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[3])){
						dateTime[2] = dateTime[2] + DateDiff(dateStr[3],start);
						dateTime[3] = dateTime[3] + DateDiff(end,dateStr[3]);
					}else if(compareDate(end,dateStr[4])){
						dateTime[2] = dateTime[2] + DateDiff(dateStr[3],start);
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + DateDiff(end,dateStr[4]);
					}else if(compareDate(end,dateStr[5])){
						dateTime[2] = dateTime[2] + DateDiff(dateStr[3],start);
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
					}else if(compareDate(end,dateStr[6])){
						dateTime[2] = dateTime[2] + DateDiff(dateStr[3],start);
						dateTime[3] = dateTime[3] + 86400;
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);;
					}
				}else if(compareDate(this.startime, dateStr[3])){
					if(compareDate(end,start)){
						dateTime[3] = dateTime[3] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[4])){
						dateTime[3] = dateTime[3] + DateDiff(dateStr[4],start);
						dateTime[4] = dateTime[4] + DateDiff(end,dateStr[4]);
					}else if(compareDate(end,dateStr[5])){
						dateTime[3] = dateTime[3] + DateDiff(dateStr[4],start);
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
					}else if(compareDate(end,dateStr[6])){
						dateTime[3] = dateTime[3] + DateDiff(dateStr[4],start);
						dateTime[4] = dateTime[4] + 86400;
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
					}
				}else if(compareDate(this.startime, dateStr[4])){
					if(compareDate(end,start)){
						dateTime[4] = dateTime[4] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[5])){
						dateTime[4] = dateTime[4] + DateDiff(dateStr[5],start);
						dateTime[5] = dateTime[5] + DateDiff(end,dateStr[5]);
					}else if(compareDate(end,dateStr[6])){
						dateTime[4] = dateTime[4] + DateDiff(dateStr[5],start);
						dateTime[5] = dateTime[5] + 86400;
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
					}
				}else if(compareDate(this.startime, dateStr[5])){
					if(compareDate(end,start)){
						dateTime[5] = dateTime[5] + DateDiff(end,start);
					}else if(compareDate(end,dateStr[6])){
						dateTime[5] = dateTime[5] + DateDiff(dateStr[6],start);
						dateTime[6] = dateTime[6] + DateDiff(end,dateStr[6]);
					}
				}else if(compareDate(this.startime, dateStr[6])){
					if(compareDate(end,start)){
						dateTime[6] = dateTime[6] + DateDiff(end,start);
					}
				}
				
				
			});
		}
		
		// ========= 折线图
		var myChartThree = echarts.init(document.getElementById('fourth'));

        // 指定图表的配置项和数据
       var colors = ['#5793f3', '#d14a61', '#675bba'];
optionThree = {
    color: colors,

    tooltip: {
        trigger: 'none',
        axisPointer: {
            type: 'cross'
        }
    },
    legend: {
        data: ['2016 降水量']
    },
    grid: {
        top: 70,
        bottom: 50
    },
    xAxis: [
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                onZero: false,
                lineStyle: {
                    color: colors[1]
                }
            },
            axisPointer: {
                label: {
                    formatter: function (params) {
                        return '降水量  ' + params.value
                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
                    }
                }
            },
            data: [dateStr[0],dateStr[1],dateStr[2],dateStr[3],dateStr[4],dateStr[5],dateStr[6]]
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name:'2016 降水量',
            type:'line',
            smooth: true,
            data: [dateTime[0]/3600,dateTime[1]/3600 , dateTime[2]/3600, dateTime[3]/3600, dateTime[4]/3600, dateTime[5]/3600, dateTime[6]/3600]
        }
    ]
};

        // 使用刚指定的配置项和数据显示图表。
myChartThree.setOption(optionThree);
		
		
		
		
	}, "json");
   
}






function test(){
	var clen = 7;
    var currentFirstDate;
    var dateStr = new Array()
    var formatDate = function(date){             
        var year = date.getFullYear()+'-';
        var month = (date.getMonth()+1);
        var day = date.getDate()+' ';
        if (month >= 1 && month <= 9) {
            month = "0" + month+'-';
        }
        if (day >= 0 && day <= 9) {
        	day = "0" + day+' ';
        }
//        var week = '('+['星期天','星期一','星期二','星期三','星期四','星期五','星期六'][date.getDay()]+')';  

//        return year+month+day+' '+week;
        return year+month+day;
    };
    var addDate= function(date,n){       
        date.setDate(date.getDate()+n);        
        return date;
    };
    var setDate = function(date){             
        var week = date.getDay()-1;
//        date = addDate(date,week*-1);
        //定义最初的日期
        date = addDate(date,-6);
        currentFirstDate = new Date(date);

        for(var i = 0;i<clen;i++){                 
        	 console.log(formatDate(i==0 ? date : addDate(date,1)));
        	 dateStr[i] =formatDate(date);
        }                
    };  
    setDate(new Date());
    return dateStr;
}
//大，小
function DateDiff(end,start){
	var strDate1=end.replace(/-/g,"/"); 
	var strDate2=start.replace(/-/g,"/"); 
	var date1 = Date.parse(strDate1); 
	var date2 = Date.parse(strDate2); 
	return (date1-date2)/(1000);
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
function compareDate(startTime,endtime){
//	var curTime = new Date();
	//2把字符串格式转换为日期类
	console.log("startTime======"+startTime);
	startTime = new Date(Date.parse(startTime.split(" ")[0]));
	endTime = new Date(Date.parse(endtime.split(" ")[0]));
	//3进行比较
	return (startTime<=endTime);
}
 
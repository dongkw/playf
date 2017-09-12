$(document).ready(function () {
    var chart = new Highcharts.Chart({
        chart: {
            padding:0,
            marginTop: -20,
            renderTo: 'container',
            polar: true,
            backgroundColor:'transparent',
            type: 'area'
        },
        title: {
            align: 'center',
            verticalAlign: 'bottom',
            text: '放松能力综合图谱',
            y:-20,
            style: {
                color: '#FFF',
                fontWeight: 'bold'
            }
        },
        credits:{
            enabled: false
        },
        exporting: {
            enabled: false
        },
        pane: {
            size: '72%',
            startAngle: 0,
            center: ['50%', '50%']
        },
        plotOptions: {
            area: {
                fillOpacity: 0.50,
                dataLabels: {//各个维度的数值显示
                    color:"#fff",
                    enabled: true,
                    style: {
                        color: '#fff',//颜色
                        fontSize:'22px'  //字体
                    },
                    allowOverlap: true
                }
            }
        },
        xAxis: {
            gridLineColor: '#4f96b5',
            categories: ['云层想象放松', '海滩瑜伽放松', '森林呼吸温差放松', '湖泊冥想放松','星空催眠放松', '综合放松训练'],
            tickmarkPlacement: 'on',
            lineWidth: 0,
            labels: {
                style: {
                    color: '#84fd9e',//颜色
                    fontSize:'16px'  //字体
                }
            },
            showFirstLabel:true
        },
        yAxis: {
            gridLineColor: '#c8edc7',
            gridLineDashStyle: 'solid',
            gridLineInterpolation: 'polygon',
            lineWidth: 0,
            //labels: {
            //    style: {
            //        color: '#f3f6fb',//颜色
            //        fontSize:'22px'  //字体
            //    }
            //},
            min: 0
        },
        tooltip: {
            shared: true,
            pointFormat: ' <b>{point.y:,.0f}</b>'
        },
        legend : {
            enabled: false
        },
        series: [{
            data: [7, 3, 6, 3, 9, 2],
            pointPlacement: 'on',
            //color: '#017fc4'
            color: '#2897c6'
        } ]
    });
    //chart.series[0].points[0].onMouseOver();
});



var _sssss;
$(function(){
	
	$('body').prepend(
		'<div class="map_frame" map >'+
			'<a id="fixed" href="javascript:void(0)" >获取数据</a>'+
			'<div class="map_frame_top">'+
				'<div class="map_frame_top_title">地图位置</div>'+
				'<div class="map_frame_top_close" id="mapClose" style="display:none;">'+
					'<a href="javascript:void(0)">×</a>'+
				'</div>'+
			'</div>'+
			'<div class="map_frame_main">'+
				'<div class="map_frame_main_fn">'+
					'<div>'+
						'当前位置:<span id="currentCity"></span>'+
						'<input type="text" id="suggestId" placeholder="请输入搜索位置..."  style="height: 25px;line-height: 25px"/>'+
					'</div>'+
					'<div id="searchResultPanel"></div>'+
				'</div>'+
				'<div id="allmap"></div>'+
			'</div>'+
		'</div>'
	);
	
    var i = 0;
    $('[map-start]').click(function(){
    	var iTop = (document.body.clientHeight -$('[map]').height())/2;
        var iLeft = ( document.body.clientWidth -$('[map]').width())/2;
        $('[map]').css({'top':isApp?(0+'px'):(iTop + 'px'),'left':isApp?0:iLeft + 'px'});
        $(".map_frame_top").mousedown(function(){
        	$(this).css("cursor","move");
        	drag($('[map]')[0],event);
        }).mouseup(function(){
        	$(this).css("cursor","default");  
        });
        $('[map]').css({display : 'block'});
        i++;
        if(i == 1){
            loadJScript();
        }
        
    });

    //获取地图位置信息 
    $('#fixed').click(function(){
		//map-click   
		var func= $("[map-click]").attr('map-click')
		eval(func+'('+JSON.stringify(_sssss)+')');
	})

    $('#resetdw').click(function(){
        init();
    })
    
})

//实现异步加载
function loadJScript() {
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = "http://api.map.baidu.com/api?v=2.0&ak=UoqWBFUb3N1WYWR1tpYxctC97OxkAKWE&callback=init";
	document.body.appendChild(script);
}

var currPoint = null;
//初始化地图
function init(){	
	var map = new BMap.Map('allmap',{enableMapClick: false});
	map.centerAndZoom('重庆',12);
	var geolocation = new BMap.Geolocation();    
	var gc = new BMap.Geocoder();
	map.addControl(new BMap.CityListControl({
		anchor:BMAP_ANCHOR_TOP_RIGHT,
		offset: new BMap.Size(215, 5),
		onChangeAfter:function(){
      		currPoint = setMarker(map,map.getCenter());
      		getAddress(gc,currPoint,function(rs){
	  			_sssss=rs;
	  		});
    	}
	}));
	
	// 定义一个控件类，即function  
	function ZoomControl(){  
	    // 设置默认停靠位置和偏移量  
	    this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;  
	    this.defaultOffset = new BMap.Size(10,10);
	}  
	// 通过JavaScript的prototype属性继承于BMap.Control  
	ZoomControl.prototype = new BMap.Control();
	ZoomControl.prototype.initialize = function(map){   
	    var div = document.createElement("div");
	    var img = document.createElement("img");
	    img.setAttribute('src',path+'/map/map_dw.png');
	    img.setAttribute('title','定位');
	    div.appendChild(img);   
	    div.style.cursor = "pointer"; 
	    div.onclick = function(e){  
	        init();  
	    }  
	    // 添加DOM元素到地图中  
	    map.getContainer().appendChild(div);  
	    // 将DOM元素返回  
	    return div;  
	}  
	// 创建控件实例  
	var myZoomCtrl = new ZoomControl();  
	// 添加到地图当中
	map.addControl(myZoomCtrl);

    var opts = {anchor :BMAP_ANCHOR_BOTTOM_LEFT,type: BMAP_NAVIGATION_CONTROL_SMALL};
    map.addControl(new BMap.NavigationControl(opts));

    map.enableScrollWheelZoom();
	map.enableInertialDragging();
	map.enableContinuousZoom();

	map.addEventListener("moveend",function(){
		// if (isApp) currPoint=setMarker(map,map.getCenter());
		var gc = new BMap.Geocoder()
		gc.getLocation(map.getCenter(),function(rs){
			console.log(rs)
		})
	})

	geolocation.getCurrentPosition(function(r){   //定位结果对象会传递给r变量  

        if(this.getStatus() == BMAP_STATUS_SUCCESS){  //通过Geolocation类的getStatus()可以判断是否成功定位。  
            var pt = r.point;
            currPoint = setMarker(map,pt);
        }else{
        	currPoint = setMarker(map,map.getCenter());     //创建一个处于当前可见地图中心的标注
            switch(this.getStatus()){  
                case 2:  
                    alert( '位置结果未知 获取位置失败.' );  
                break;  
                case 3:  
                    alert( '导航结果未知 获取位置失败.' );  
                break;  
                case 4:  
                    alert( '非法密钥 获取位置失败.' );  
                break;  
                case 5:  
                    alert( '对不起,非法请求位置  获取位置失败.' );  
                break;  
                case 6:  
                    alert( '对不起,当前 没有权限 获取位置失败.' );  
                break;  
                case 7:  
                    alert( '对不起,服务不可用 获取位置失败.' );  
                break;  
                case 8:  
                    alert( '对不起,请求超时 获取位置失败.' );  
                break;   
            }  
    	}          

	},  
	{
		enableHighAccuracy: true
	});

	keywordSearch(map,gc);

	//监听地图拖动
	map.addEventListener('dragend', function(){
        var cp = map.getCenter();
		if (isApp) {
            setMarker(map, cp);
        }else {
            var bound=map.getBounds();       //地图可视区域
            if(!bound.containsPoint(currPoint)){    //判断标注是否在可视区域内
            	map.clearOverlays();
            	setMarker(map,cp);
            }
		}

	});
}




//关键词检索
function keywordSearch(map,geocoder){
	var ac = new BMap.Autocomplete({    //建立一个自动完成的对象
		"input" : "suggestId",
		"location" : map
	});
    ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
		var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		$('#searchResultPanel').html(str);
	});
	var myValue;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		$('#searchResultPanel').html("onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue);
		
		setPlace();
	});

	//设置坐标检索
	function setPlace(){
		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(){
			var pp = local.getResults().getPoi(0).point; //获取第一个智能搜索的结果
			map.centerAndZoom(pp, 18);
			currPoint = setMarker(map,pp);   //添加标注
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
		  onSearchComplete: myFun
		});
		local.search(myValue);
		$('#currentCity').html(myValue);
	}

	
}

//添加标注
function setMarker(map,point){

	map.clearOverlays();
	var marker = new BMap.Marker(point);
	map.addOverlay(marker);
	var g = new BMap.Geocoder()
	getAddress(g,point,function(rs){
	  		_sssss=rs;
	  	});
	//添加标注可拖动事件
	if (!isApp){
        marker.addEventListener('dragend',function(e){
            point = this.getPosition();    //获取标注的地理位置
            map.panTo(point);
            getAddress(g,point,function(rs){
                _sssss=rs;
            });
        });
        marker.enableDragging();
	}
 	// map.panTo(point);
 	
 	return point;
}

//获取标注点坐标地址信息
function getAddress(geocoder,point,callback){
	currPoint = point;
	geocoder.getLocation(point, function(rs){
		$('#currentCity').html(rs.address);
		callback(rs);
    });
}	

//窗体拖拽
function drag(obj,e){  
    var e=e ? e : event;  
    var mouse_left=e.clientX-obj.offsetLeft;   //鼠标距盒子左边距离
    var mouse_top=e.clientY-obj.offsetTop;     //鼠标句盒子上边距离
    var docmousemove=document.onmousemove;  
    var docmouseup=document.onmouseup;  
    document.onselectstart=function(e){return false} //鼠标禁止选中文字
    document.onmouseup=function(){  
        document.onmousemove=docmousemove;  
        document.onmouseup=docmouseup;  
        document.onselectstart=function(e){return true}  
    }  
    document.onmousemove=function(ev){  
        var ev=ev ? ev : event;  
        if(ev.clientX-mouse_left>0&&document.documentElement.clientWidth-(ev.clientX-mouse_left)-obj.offsetWidth+document.documentElement.scrollLeft>0){  
            obj.style.left=(ev.clientX-mouse_left)+"px";  
        }  
        if(ev.clientY-mouse_top>0&&document.documentElement.clientHeight-(ev.clientY-mouse_top)-obj.offsetHeight+document.documentElement.scrollTop>0){  
            obj.style.top=(ev.clientY-mouse_top)+"px";  
        }  
    }  
}





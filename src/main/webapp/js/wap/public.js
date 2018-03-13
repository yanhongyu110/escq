var getChild = {
	prev: function(obj){
		var p = obj.previousSibling;
		if (!p) {return null};
		return p.nodeType == 1 ? p : this.prev(p);
	},
	next: function(obj){
		var n = obj.nextSibling;
		if (!n) {return null};
		return n.nodeType == 1 ? n : this.next(n);
	},
	all: function(obj){
		if (!obj) {return null};
		var arr = [];
		for(var i=0,len=obj.childNodes.length;i<len;i++){
			if(obj.childNodes[i].nodeType==1){
				arr.push(obj.childNodes[i]);
			}
		}
		return arr;
	},
	label: function(label, oParent) {
		var aClass = [];
		var reClass = new RegExp("(^| )" + label + "( |$)");
		var aElem = oParent.getElementsByTagName('*');
		for (var i = 0; i < aElem.length; i++) reClass.test(aElem[i].getAttribute('data-type')) && aClass.push(aElem[i]);
		return aClass;
	}
}
var $$ = function (id , tag) {
    var re = (id && typeof id != "string") ? id : document.querySelector( id );
    return tag ? re.getElementsByTagName(tag) : re;
}
var Element = {
    hasClass:function(obj,name){
        return (' '+obj.className+' ').indexOf(' '+name+' ') > -1 ? true : false;
    },
    addClass : function(obj,name){
        if(this.hasClass(obj,name)) return;
        obj.className += ' ' + name;
    },
    removeClass : function(obj,name){
        obj.className = obj.className.replace(new RegExp('(^|\\s)' +name+ '(?:\\s|$)'),'$1').replace(/\s{1,}/g,' ');
    },
    position : function(obj){
        var s={x:0,y:0};
            while(obj){
                s.x+=obj.offsetLeft;
                s.y+=obj.offsetTop;
                obj=obj.offsetParent;
            }
        return s;
    }
}
var doc = document, doe = doc.documentElement;
function addEvent(o, s, f) { doc.attachEvent ? o.attachEvent('on' + s, f) : o.addEventListener(s, f, false); }
function $$(id, tag) { var re = typeof id != "string" ? id : document.getElementById(id); return !tag ? re : re.getElementsByTagName(tag); };
/**
 * 
 * Request
 *   ajax,jsonp
 * 
 * **/
;(function(){
function minMaxRandom(under,over){
    switch(arguments.length){
        case 1: return parseInt(Math.random()*under);
        case 2: return (parseInt(Math.random()*(over-under+1))+parseInt(under));
        default:return 0;
    };
}

function Request() {
};
Request.prototype = {
    ajax : function(args) {
        this.options = {
            type : 'GET',
            dataType : 'text',
            async : true,
            avatar : null,
            contentType : 'application/x-www-form-urlencoded',
            url : 'about:blank',
            data : {},
            success : {},
            error : {}
        };
        if (!args) {
            console.error('please fill in any parameters first!');
            return;
        } else if (!args.url) {
            console.error('url is required parameters, please check your parameters!');
            return;
        } else if (!args.success || typeof args.success != 'function') {
            console.error('the callback function is lost!');
            return;
        }
        this.shift(this.options, args);
        this.send();
    },
    jsonp : function(args) {
        this.options = {
            type : 'JSONP',
            jsonpName : '',
            dataType : 'text',
            async : true,
            avatar : null,
            url : 'about:blank',
            success : function(){},
            data : {}
        };
        if (!args) {
            console.error('please fill in any parameters first!');
            return;
        } else if (!args.url) {
            console.error('url is required parameters, please check your parameters!');
            return;
        } else if (!args.jsonpName) {
            args.jsonpName = 'jsonpCallbackFunctionNo' + new Date().getTime() + minMaxRandom(0, 9999);
        }

        this.shift(this.options, args);
        if (window[this.options.jsonpName] && window[this.options.jsonpName] !== this.options.success) {
            console.error('jsonpName already exists!');
            return;
        }
        window[this.options.jsonpName] = this.options.success;
        this.create();
    },
    create : function() {
        var script = document.createElement('script'), argStr = /[\?]/g.test(this.options.url) ? '&' : '?';
        for (var key in this.options.data) {
            argStr += key + '=' + this.options.data[key] + '&';
        }
        argStr = argStr + 'callback=' + this.options.jsonpName;
        script.async = this.options.async;
        script.src = this.options.url + (argStr == '?' ? '' : argStr);
        document.getElementsByTagName('head')[0].appendChild(script);
    },
    XmlHttp : function() {
        var xmlHttp;
        try {
            xmlhttp = new XMLHttpRequest();
        } catch(e) {
            try {
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch(e) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        if (!xmlhttp) {
            return false;
        }
        return xmlhttp;
    },
    send : function() {
        var xmlHttp = this.XmlHttp(), linkSign = /[\?]/g.test(this.options.url) ? '&' : '?', argStr = '', _this = this, length = this.options.data ? this.options.data.length : 0;
        for (var key in this.options.data) {
            argStr += key + '=' + this.options.data[key] + '&';
        }
        argStr = argStr.replace(/\&$/g, '');
        if (this.options.type.toUpperCase() == 'GET') {
            xmlHttp.open(this.options.type, this.options.url + (argStr == '' ? '' : linkSign + argStr), this.options.async);
        } else {
            xmlHttp.open(this.options.type, this.options.url, this.options.async);
        }
        xmlHttp.setRequestHeader('Content-Type', this.options.contentType);
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200 || xmlHttp.status == 0) {
                    if ( typeof _this.options.success == 'function') {
                        var responseData = _this.options.dataType == 'text' ? xmlHttp.responseText : xmlHttp.responseXML;
                        _this.options.success(responseData, _this.options.dataType,_this.options.avatar);
                    }
                    xmlHttp = null;
                } else {
                    if ( typeof _this.options.error == 'function')
                        _this.options.error('Server Status: ' + xmlHttp.status);
                }
            }
        };
        xmlHttp.send(this.options.type.toUpperCase() == 'POST' ? argStr : null);
    },
    shift : function(o, args) {
        for (var i in args) {
            o[i] = args[i];
        };
        return o;
    }
}; 

    
 window['Request'] = function(){
    return new Request();
 };

})();

//滑动导航效果 及 处理当前选中状态
function moveNav(box,n){
    var oBox = $(box).get(0);
    if (!oBox) {return};
    var index = n || 0;
    var initialSlide = index>=3 ? index-3 : 0;
    var swiper = new Swiper(box, {
        slidesPerView : 6,
        freeMode:true,
        slidesPerGroup : 6,
        slidesOffsetBefore:0,
        // centeredSlides : true
    });
    // oBox.addEventListener('click',function(e){
    //     var tag = e.target;
    //     if (tag.nodeName == 'A' && tag.className.indexOf('on')<0) {
    //         _hmt.push(['_trackEvent',tag.innerHTML,'click'])
    //     };
    // },false)

    // function navSwiper(){
    //     var iW = document.documentElement.clientWidth||document.body.clientWidth;
    //     if (iW>540) {
    //         iW=540;
    //     };
    //     oBox.style.width =  iW+'px';
    //     swiper.onResize();
    // }
    // //navSwiper();
    //
    // var timer = null;
    // window.addEventListener('resize', function(e){
    //     clearTimeout(timer);
    //     timer = setTimeout(function(){
    //         navSwiper();
    //     },300)
    // },false);
}




function searchShow(box,btn){
    var oBox = document.querySelector(box);
    var oBtn = document.querySelector(btn);
    var oSub = oBox.querySelector('.search_sub');
    oBtn.addEventListener('click',function(e){
         Element.addClass(oBtn,'on');
         Element.addClass(oBox,'on');
    },false)
    oSub.addEventListener('click',function(e){
        if (Element.hasClass(oBtn,'on')) {
            Element.removeClass(oBox,'on');
            setTimeout(function(){
                Element.removeClass(oBtn,'on');
            },400)
        }
    },false)
}

function searchSelect(json){
    var oBtn = document.querySelector(json.btn);
    var oBox = document.querySelector(json.box);
    var oInput = document.querySelector(json.input);
    var iUrl = json.url||'http://www.yoka.com/dna/server1/HotTag.aspx?tag=';
    var btnUrl = json.btnUrl||'/dna/m/search/';
    var req = Request();
    if (!oBtn || !oBox || !oInput || !iUrl) {return};
    var oUl = oBox.getElementsByTagName('ul')[0];
    oInput.addEventListener('input',function(e){
        toChange();
    },false)
    function toChange(){
        if(oInput.value==''){hide(); return;}
        var oValue = oInput.value.replace(/\s+/g," ");
        req.jsonp({
               url: iUrl+oValue,
               success: function(str){
                      arr = str;
                      var len = arr.length;
                      if(!len){hide(); return;}
                      var aLi = '';
                      for(var i=0;i<len;i++){
                          aLi += '<li title="'+arr[i][0]+'"><a target="_self" href="/dna/m/t'+arr[i][2]+'">'+arr[i][0]+'<span>'+arr[i][1]+'</span></a></li>';
                      }
                      oUl.innerHTML = aLi;
                      show();
               }
         });
    }
    oBox.addEventListener('click',function(e){
        var tag = e.target;
        if (tag.nodeName == 'A') {
            hide();
        };
    },false)
    oBtn.addEventListener('click',function(){
        if (oInput.value != '') {
            window.location.href = btnUrl+oInput.value;
        };
        hide();
    },false)
    function hide(){
        oBox.style.display = 'none';
    }
    function show(){
        oBox.style.display = 'block';
    }
}

function lazyload(){
    function each(ar,fn){
        for(var i=0,l=ar.length;i<l;i++){
            fn.call(ar[i],i);
        }
    }
    var addEvent = (function(){ 
        return document.attachEvent ? 
            function(obj,type,fn){ 
                obj.attachEvent('on'+type,fn)
            } : 
            function(obj,type,fn){ 
                obj.addEventListener(type,fn,false)
            }
        })()
    var removeEvent = (function(){ 
            return document.attachEvent ? 
                function(obj,type,fn){ 
                    obj.detachEvent('on'+type,fn)
                } : 
                function(obj,type,fn){ 
                    obj.removeEventListener(type,fn,false)
                }
        })()
    
    var imgs = document.getElementsByTagName('img'),
        body = document.getElementsByTagName('body')[0],
        sHeight = document.documentElement.clientHeight || document.body.clientHeight,
        sWidth = document.documentElement.clientWidth || document.body.clientWidth,
        overflow = [ sWidth , sHeight+400] ,
        range ={
            x:[0,overflow[0]],
            y:[0,overflow[1]]
        };
    
    function filter(){
        if(imgs.length ==0){
            removeEvent(window,'scroll',filter);
            return;
        }
        var _ar = [],
            site = {
                x:document.body.scrollLeft || document.documentElement.scrollLeft,
                y:document.body.scrollTop || document.documentElement.scrollTop
            },
            range = {
                x:[site.x-overflow[0]/2 , site.x+overflow[0]],
                y:[site.y-overflow[1]/2 , site.y+overflow[1]]
            },
            temp = null;
        each(imgs,function(){
            temp = getSite(this);
            //if(temp.x>=range.x[0] && temp.x <= range.x[1] && temp.y >= range.y[0] && temp.y <= range.y[1]){
            if(temp.y >= range.y[0] && temp.y <= range.y[1]){
                this.src = this.getAttribute('_src');
                //this.removeAttribute('_src');
            }else{
                _ar.push(this);
            }
        })
        imgs = [].concat(_ar);
        _ar = null;
        return imgs;
    }
    
    function getSite(obj){
        var s={x:0,y:0};
            while(obj){
                s.x+=obj.offsetLeft;
                s.y+=obj.offsetTop;
                obj=obj.offsetParent;
            }
        return s;
    }
    
    function init(){
        var ar = [];
        each(imgs,function(){
            if(this.getAttribute('_src')){
                ar.push(this)
            }
        })
        imgs = [].concat(ar);
        ar = null;
        filter();
    }
    
    init();
    
    addEvent(window,'scroll',filter);
    addEvent(window,'resize',function(){
        sHeight = document.documentElement.clientHeight || document.body.clientHeight;
        sWidth = document.documentElement.clientWidth || document.body.clientWidth;
        overflow = [ sWidth , sHeight ];
        filter();
    })

}


/*
 * async loader
 * dom ready
 **/
(function(){
    var loaded = {},
        loadingFiles = {},
        loadList = {},
        mods = {},
        isReady = false,
        readyList = [],
        f = document.getElementsByTagName('script')[0],
        y;
    
    function load(url,charset,callback){
        if(loaded[url]){
            loadingFiles[url] = false;
            callback && callback(url);
            return;
        }
        if(loadingFiles[url]){
            setTimeout(function(){
                load(url,charset,callback);
            },10);
            return;
        }

        loadingFiles[url] = true;
        
        var n,
            done = function(){
                loaded[url] = 1;
                callback && callback(url);
                callback = null;
            },
            t;
        
        t = url.toLowerCase().indexOf('.css') > -1 ? 'css' : 'js';
        if(t === 'css'){
            n = document.createElement('link');
            n.setAttribute('rel','stylesheet');
            n.setAttribute('type','text/css');
            n.setAttribute('href',url);

            var img = new Image();
                img.onerror = function(){
                    try{
                        done();
                    }catch(e){}
                    img.onerror = null;
                    img = null;
                }
                img.src = url;
        }else{
            n = document.createElement('script');
            n.setAttribute('type','text/javascript');
            n.src = url;
            n.async = true;

            n.onerror = function(){
                console.log(url+' is load fail;');
                try{
                    done();
                }catch(e){}
                n.onerror = null;
            }
        }
        
        if(charset){
            n.charset = charset;
        }

        
        n.readyState ? n.onreadystatechange = function(){
            if( /loaded|complete/.test(n.readyState)){
                done();
                n.onreadystatechange = null;
            }
        } : n.onload = function(){
            done();
            n.onload = null;
        }
        
        f.parentNode.insertBefore(n,f);
    }

    function loadDeps(deps,callback){
        var mod, 
            len = deps.length,
            id = deps.join('');

        if(loadList[id]){
            callback && callback();
            return;
        }
        function complete(){
            if(!--len){
                loadList[id] = 1;
                callback && callback();
            }
        }

        for(var i=0,l=deps.length;i<l;i++){
            if(typeof deps[i] === 'string' ){
                mod = (mods[deps[i]]) ? mods[deps[i]] : {path : deps[i]};
            }else{
                mod = deps[i];
            }
            if(mod.requires){
                loadDeps(mod.requires,(function(mod,key){
                    return function(){ 
                        load(mod.path,mod.charset,function(){ 
                            if(mod.callback){
                                mod.callback();
                                mods[key].callback = null; 
                            }
                            complete(); 
                        });
                    }
                })(mod,deps[i]))
            }else{
                load(mod.path,mod.charset,(function(mod,key){ 
                    return function(){
                        if(mod.callback){
                            mod.callback();
                            mods[key].callback = null; 
                        }
                        complete(); 
                    }
                })(mod,deps[i]));
            }
        }
    }

    var loader = function(){
        var args = [].slice.call(arguments),
            fn,
            id;

        if(typeof args[args.length-1] === 'function'){
            fn = args.pop();
        }
        if( args.length === 0 ){
            fn && fn();
            return;
        }
        id = args.join('');
        if(loadList[id]){
            fn && fn();
            return;
        }
        loadDeps(args,function(){
            fn && fn();
        })
    }

    loader.add = function(name,value){
        if(!name || !value){
            return;
        }
        var _mod = [];
        if(name === 'mods'){
            for(var key in value){
                if(value.hasOwnProperty(key) && value[key].path){
                    mods[key] = value[key];
                    _mod.push(key);
                }
            }
        }else if( value.path ){
            mods[name] = value;
            _mod.push(name);
        }
        loadDeps(_mod);
        _mod = null;
    }


    window['Y'] = loader;

    
    /*!
     * contentloaded.js
     * Author: Diego Perini (diego.perini at gmail.com)
     */
    function contentLoaded(fn) {
        var done = false, top = true, win = window,
        doc = win.document, root = doc.documentElement,
        add = doc.addEventListener ? 'addEventListener' : 'attachEvent',
        rem = doc.addEventListener ? 'removeEventListener' : 'detachEvent',
        pre = doc.addEventListener ? '' : 'on',
        init = function(e) {
            if (e.type == 'readystatechange' && doc.readyState != 'complete') return;
            (e.type == 'load' ? win : doc)[rem](pre + e.type, init, false);
            if (!done && (done = true)) fn.call(win, e.type || e);
        },
        poll = function() {
            try { root.doScroll('left'); } catch(e) { setTimeout(poll, 50); return; }
            init('poll');
        };
        if (doc.readyState == 'complete') fn.call(win, 'lazy');
        else {
            if (doc.createEventObject && root.doScroll) {
                try { top = !win.frameElement; } catch(e) { }
                if (top) poll();
            }
            doc[add](pre + 'DOMContentLoaded', init, false);
            doc[add](pre + 'readystatechange', init, false);
            win[add](pre + 'load', init, false);
        }
    }

    contentLoaded(function(){
        isReady = true; 
        fireReadyList();
    });

    function fireReadyList(){
        var i=0,len=readyList.length;
        if(len){
            for( ; readyList[i]; i++){
                readyList[i]();
            }
        }
    }

    window['Domready'] = function(fn){
        if(isReady){
            fn && fn();
            return;
        }
        readyList.push(fn);
    }

})();


/** 进场广告 **/
function adInsert(json){
    var oBox = $$(json.box),
        iSrc = json.src||'',
        iLink = json.link||'javascript:;',
        iBg = json.bg||'',
        iTime = json.time||5,
        iValign = json.valign||false,
        iLoad = json.load||false,
        oClose = null,obj=null,
        bSession = json.session||null,
        aItem = window.sessionStorage.getItem('adItem')||0,
        timer = null,scale=1,iH=0,iW=0;

    if (bSession) {
        if (aItem) {return};
        window.sessionStorage.setItem('adItem',1);
    };
    init();
    function init(){
        if (!iLoad) {
            oBox.style.display = 'block';
        };
        var aImg = new Image();
        if (iBg) {
            oBox.style.backgroundColor = iBg;
        };
        iW = document.body.clientWidth;
        iH = document.body.clientHeight;
        scale = iW/iH;
        aImg.onload = function(e){
            obj = document.createElement('div');
            var html = '<a target="_blank" href="'+iLink+'"><img src="'+iSrc+'" alt=""></a><span class="close">关闭</span>';
            obj.innerHTML = html;
            obj.style.cssText = 'width: 100%;height: 100%;overflow: hidden;-webkit-transition:0.5s ease-in;opacity: 0;position: relative;';
            var h = iW/aImg.width*aImg.height;
            if (h<iH) {
                obj.style.height = h+'px';
                obj.style.marginTop = (iH-h)/2+'px';
            }
            oBox.appendChild(obj);
            if (iLoad) {
                oBox.style.display = 'block';
            };
            setImg($$(obj,'img')[0]);
            setTimeout(function(){
                obj.style.opacity = 1;
            },100)
            oClose = oBox.getElementsByClassName('close')[0];
            timer = setTimeout(fnClose,iTime*1000);
            if (oClose) {
                oClose.addEventListener('click',function(){
                    fnClose(e)
                },false)
            };
        }
        aImg.src = iSrc;
        document.addEventListener('touchmove',stop,false)
    }

    function setImg(o){
        if (!o) {return};
        if (iValign) {
            o.style.height = '100%';
        }else{
            o.style.width = '100%';
        }
    }
    
    function fnClose(e){
        clearTimeout(timer);
        obj.style.opacity = 0;
        setTimeout(function(){
            oBox.style.display = 'none';
            oBox.innerHTML = '';
            document.removeEventListener('touchmove',stop,false)
        },500)
        
    }

    function stop(e){
        e.preventDefault();
    }
}

var Tools = {
    share : function(btn,box){
        var oBtn = $$(btn)||null;
        var oBox = $$(box)||null;
        if (!oBtn || !oBox) {return;};
        var oClose = oBox.querySelector('.close');
        oBtn.addEventListener('click',function(e){
            show()
        },false)
        oClose.addEventListener('click',function(e){
            hide();
        },false)
        oBox.addEventListener('touchmove',function(e){
            e.preventDefault();
        },false)
        function hide(){
            Element.removeClass(oBox,'on');
        }
        function show(){
            Element.addClass(oBox,'on');
        }
    }
}
/** 背景色广告 **/
function headAd(box,data){
    var oData = data;
    var oBox = document.getElementById(box);
    var url,iColor;
    var body = document.querySelector('.container')||null;
    if (!oBox || !body) {return};
    if (oData) {
        url = oData.bgurl;
        iColor = oData.color;
    };
    if (url) {
        //body.style.cssText += 'background: '+iColor+' url('+url+') no-repeat center 170px;';
        oBox.style.backgroundImage = 'url('+url+')';
    };
    if (iColor) {
        oBox.style.backgroundColor = iColor;
        body.style.backgroundColor = iColor;
    };
    if (url||iColor) {
        oBox.style.display = 'block';
    };
}
$(function(){
	getSrceenWH();
	$(window).scroll(function() {
		if ($(window).scrollTop() > 200) {
			$(".xy_header_nav").css("background","rgba(0,0,0,.6)");
			$(".thenav").css("color","white");
		}
	});
    $('.sub').click(function(){
    	var flag = "a";
    	var search = $('#searchText').val();
    	var type = $('.select_box').find('li.selected').attr('value');
    	if(typeof(type)=='undefined'){
    		type = '';
    	}
    	jQuery('<form action="' + path + '/search/view.html"  method="post">'
                + '<input type="hidden" name="search" value="' + search + '" />'
                + '<input type="hidden" name="flag" value="' + flag + '" />'
                + '<input type="hidden" name="type" value="' + type + '" />'
                + '</form>').appendTo('body').submit().remove();
    });
    $('#log').click(function () {
        className = $(this).attr('class');
        $('#dialogBg').fadeIn(300);
        $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
        $('.product-wrap div.product').eq(0).fadeIn(150).siblings('div.product').hide();
        var liWidth = $('.title-list li').width();
        $('.lanrenzhijia .title-list p').stop(false, true).animate({'left': 0 * liWidth + 'px'}, 300);
        $("#li2").addClass('on').siblings().removeClass('on');
    });
    $('#regidest').click(function () {
        className = $(this).attr('class');
        $('#dialogBg').fadeIn(300);
        $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
        $('.product-wrap div.product').eq(1).fadeIn(150).siblings('div.product').hide();
        var liWidth = $('.title-list li').width();
        $('.lanrenzhijia .title-list p').stop(false, true).animate({'left': 1 * liWidth + 'px'}, 300);
        $("#li1").addClass('on').siblings().removeClass('on');
    });
    $('.claseDialogBtn').click(function () {
        $("#cb").prop("checked", false);
        $(".registerBtn").unbind("click");
        $('.registerBtn').css('background', '#999');
        $('#dialogBg').fadeOut(300, function () {
            $('#dialog').addClass('bounceOutUp').fadeOut();
        });
    });
    $('.dropdown').hover(function () {
        $(this).addClass('dropdown-hover');
        $(".dropdown-sub").show('slow');
    }, function () {
        $(this).removeClass('dropdown-hover');
    });
    $('.dropdown2').hover(function () {
        $(this).addClass('dropdown-hover2');
        $(".dropdown-sub2").show('slow');
    }, function () {
        $(this).removeClass('dropdown-hover2');
    });

    $('#logout').click(function () {
        window.location.href = path + "/userinfo/logInfo/logout.html" + '?comId=' + g_comid;
    })
    $('.title-list li').click(function () {
        var liindex = $('.title-list li').index(this);
        $(this).addClass('on').siblings().removeClass('on');
        $('.product-wrap div.product').eq(liindex).fadeIn(150).siblings('div.product').hide();
        var liWidth = $('.title-list li').width();
        $('.lanrenzhijia .title-list p').stop(false, true).animate({'left': liindex * liWidth + 'px'}, 300);
    });
    checkCookieLoad();

    $('#cb').click(function () {
        if ($('#cb').is(':checked')) {
            $('.registerBtn').css('background', '#FB5A5A');
        } else {
            $('.registerBtn').css('background', '#999');
        }
    })
    $('.registerBtn').click(function () {
        if (!$('#cb').is(':checked')) {
            $('.registerBtn').css('background', '#999');
            alert("请阅读并同意专家服务协议后再点击注册");
        } else {
            $('.registerBtn').css('background', '#FB5A5A');
            saveRegister();
        }
    })
    //根据时间显示欢迎词
    var time = new Date().getHours();
    if (time < 7 || time > 20) {
        $("#hello").text("晚上好，");
    } else if (time <= 13) {
        $("#hello").text("上午好，");
    } else {
        $("#hello").text("下午好，");
    }
})
var w, h, className;
    function getSrceenWH() {
        w = $(window).width();
        h = $(window).height();
        $('#dialogBg').width(w).height(h);
    }

    window.onresize = function () {
        getSrceenWH();
    }
    $(window).resize();
    if ($.fn.datagrid) {
        $.fn.datagrid.defaults.pageSize = 30;
        $.fn.datagrid.defaults.pageList = [30, 40, 50, 60, 80, 100, 200, 300, 500, 1000, 1500, 2000];
        /*$.fn.datagrid.defaults.onLoadError=function(e){
         //alert('加载失败!');
         var html = e.responseText;
         if(html.indexOf('<title>用户登录已超时</title>')!=-1){
         location.href=path+'/timeout.jsp';
         }else if(html.indexOf('j_spring_security_check')!=-1){
         location.href=path+'/login.jsp';
         }
         };*/
    }

    function register() {
        window.location.href = path + "/userinfo/logInfo/jumpRegister.html" + '?comId=' + g_comid;
    }

    function saveRegister() {
        var logCell = $('.registerCell').val();
        var checkCode = $('.registerCode').val();
        var logPass = $('.registerPass').val();
        var flag = 1;
        if (checkNull(logCell)) {
            alert('手机号不能为空！');
        } else if (checkNull(checkCode)) {
            alert('验证码不能为空！');
        } else if (checkNull(logPass)) {
            alert('密码不能为空！');
        } else if (!checkCell(logCell)) {
            alert('手机号格式不对！');
        } else if (checkLength(logPass, 6, 20)) {
            alert('密码长度必须在6-20位之间！');
        } else {
            /*$(".registerBtn").unbind("click");*/
            $.post(path + '/userinfo/logInfo/register.html', $.param({
                'logCell': logCell,
                'checkCode': checkCode,
                'logPass': $.md5(logPass),
                'flag': flag
            }, true), function (result) {
                if (result.success) {
                    if (document.URL != path + '/userinfo/logInfo/logout.html') {
                        window.location.reload();
                    }
                    $.post(path + '/userinfo/logInfo/login.html', $.param({
                        'logName': logCell,
                        'logPass': $.md5(logPass)
                    }, true), function (result) {
                        alert("注册成功", "注册", function () {
                            window.location.href = path + "/goodsinfo/ServiceInfo/homeShow.html" + '?comId=' + g_comid;
                        })
                    }, 'json');
                } else {
                    if (result.errorCode == "2") {
                        alert(result.errorMsg, "注册", function () {
                        })
                    } else if (result.errorCode == "3") {
                        alert(result.errorMsg, "注册", function () {
                        })
                    } else if (result.errorCode == "5") {
                        alert(result.errorMsg, "注册", function () {
                        })
                    }
                }
            }, 'json');

        }


    }

    var flag = false;
    function buttonregister() {
        if (flag == false) {
            var logCell = $('.registerCell').val();
            if (checkNull(logCell)) {
                alert('手机号不能为空！');
            } else if (!checkCell(logCell)) {
                alert('请输入有效的手机号码！');
            } else {
                $.ajax({
                    type: "post",
                    url: path + '/userinfo/logInfo/validateLoginName.html',
                    dataType: 'json',
                    data: {'logCell': logCell},
                    success: function (res) {
                        if (res.success) {
                            flag = true;
                            timeOutCommon(60);
                        } else {
                            if (res.errorCode == "1") {
                                alert(res.errorMsg);
                            } else if (res.errorCode == "2") {
                                alert(res.errorMsg);
                            }
                        }
                    }
                });
            }
        }
    }

    function timeOutCommon(i) {
        if (i != 0) {
            $(".registerButton").unbind("click");
            $('.registerButton').val(i + 's可重新发送');
            $('.registerButton').css({background: '#999', border: '0px'});
            setTimeout(function () {
                timeOutCommon(i)
            }, (1000));
        } else {
            flag = false;
            $(".registerButton").click(function () {
                button();
            })
            $('.registerButton').val('获取验证码');
            $('.registerButton').css({background: '#FB5A5A', border: '1px solid #FB5A5A'});
        }
        i--;
    }
    function checkCookieLoad() {
        var coo = $.cookie('rmb');
        if ($.cookie('rmb')) {
            $(".cellPhone").val($.cookie('logName'));
            $(".logPassWord").val($.cookie('logPass'));
            $(".checkLog").attr("checked", "true");
        }
    }
    function logUser() {
        var logCell = $('.cellPhone').val();
        var logPass = $('.logPassWord').val();
        if (checkNull(logCell)) {
            alert("账号不能为空");
        } else if (checkNull(logPass)) {
            alert("密码不能为空");
        } else {
            var name = $.cookie('logName');
            var pass = $.cookie('logPass');
            if (logCell != name || logPass != pass) {
                logPass = $.md5(logPass);
            }
            var checked = $(".checkLog").is(":checked");
            if (checked) {
                $.cookie('rmb', true, {expires: 7, path: '/'});
                $.cookie('logName', logCell, {expires: 7, path: '/'});
                $.cookie('logPass', logPass, {expires: 7, path: '/'});
            } else {
                $.cookie('rmb', false, {expires: -1, path: '/'});
                $.cookie('logName', '', {expires: -1, path: '/'});
                $.cookie('logPass', '', {expires: -1, path: '/'});
            }
            $.post(path + '/userinfo/logInfo/login.html', $.param({
                'logName': logCell,
                'logPass': logPass
            }, true), function (result) {
                if (result.success) {
                    alert("登录成功", "登录", function () {
                        if (document.URL == path + '/userinfo/logInfo/logout.html') {
                            window.location.href = path + "/goodsinfo/ServiceInfo/homeShow.html" + '?comId=' + g_comid;
                        } else {
                            window.location.reload();
                        }
                    })
                } else {
                    if (result.errorCode == "1") {
                        alert(result.errorMsg);
                    } else if (result.errorCode == "2") {
                        alert(result.errorMsg);
                    }
                }
            }, 'json');
        }
    }


    //弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
    function msgShow(title, msgString, msgType) {
        $.messager.alert(title, msgString, msgType);
    }

    /**
     * 无数据显示横拉条
     */
    function scrollShow(datagrid) {
        datagrid.prev(".datagrid-view2").children(".datagrid-body").html("<div style='width:" + datagrid.prev(".datagrid-view2").find(".datagrid-header-row").width() + "px;border:solid 0px;height:1px;'></div>");
    }

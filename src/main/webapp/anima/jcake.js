/**
 * Created by blazh on 2016/10/30.
 */

/**
 * jqcake
 */
(function () {



    //根据数据模板更改
    $.fn.changeUnityContent = function (content, filterCallbak) {
        this.each(function () {
            var src = $(this)
            content.map(function (it, index) {
                if (filterCallbak != null && filterCallbak != undefined)
                    filterCallbak(src[0], it)
                for (var _name in content) {
                    src.find('.' + _name).setContent(it[_name])
                }
            })
        })
    }

    //停止css3
    $.fn.stopCSS3 = function () {
        this.css('transition', 'left 0s linear');
    }

    //得到内容
    $.fn.getContent = function () {
        if (this.get(0) instanceof  HTMLInputElement || this.get(0) instanceof  HTMLTextAreaElement || this.get(0) instanceof  HTMLSelectElement) {
            return this.val()
        } else {
            return this.text()
        }
    }

    //改变内容
    $.fn.setContent = function (inp) {
        this.each(function () {
            if ($(this).get(0) instanceof  HTMLInputElement || $(this).get(0) instanceof  HTMLTextAreaElement || $(this).get(0) instanceof  HTMLSelectElement) {
                $(this).val(inp)
            } else {
                $(this).text(inp)
            }
        })
        return this
    }

    //元素滚动进入
    $.fn.scrollView = function (callback, callback1) {
        this.each(function () {
            var isDo = false
            var it = $(this)
            $(window).scroll(function () {
                if ($('body').scrollTop() <= it.offset().top + it.height() && $('body').scrollTop() + $(window).height() >= it.offset().top) {
                    if (!isDo) {
                        if (callback != null && callback != undefined)
                            callback.call(it)
                        isDo = true;
                    }
                } else {
                    if (isDo) {
                        if (callback1 != null && callback1 != undefined)
                            callback1.call(it)
                        isDo = false;
                    }
                }
            })
        })
        return this
    }

    //固定窗口
    $.fn.toFixed = function (top, left) {
        top = top || 0;
        left = left || 0;
        this.css({position: 'fixed', top: top + 'px', left: left + 'px'})
        return this
    }

    //固定页面
    $.fn.toAbsolute = function (top, left) {
        top = top || 0;
        left = left || 0;
        this.css({position: 'absolute', top: top + 'px', left: left + 'px'})
        return this
    }

    //取消固定
    $.fn.toStatic = function () {
        this.css({position: 'static'})
        return this
    }

    //滑动至顶部
    $.ScrollToTop = function (time, callback) {
        $('body').animate({scrollTop: 0}, time, callback)
    }

    //滑动至底部
    $.ScrollToBottom = function (time, callback) {
        $('body').animate({scrollTop: $(document).height()}, time, callback)
    }

    //滑动至指定位置
    $.ScrollToPoint = function (top, time, callback) {
        $('html,body').animate({scrollTop: top}, time, callback)
    }

    //指定点离开事件
    $.ScrollPoint = function (top, callback, callback1) {
        var isDo = false;
        $(window).scroll(function () {
            if ($('body').scrollTop()>= top) {
                console.log(isDo)
                if (!isDo) {
                    if (callback != null && callback != undefined)
                        callback()
                    isDo = true;
                }
            } else {
                if (isDo) {
                    if (callback1 != null && callback1 != undefined)
                        callback1.call()
                    isDo = false;
                }
            }
        })
    }


})()
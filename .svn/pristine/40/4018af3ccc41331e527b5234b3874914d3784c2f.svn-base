//拓展验证

//isEmail   邮箱验证
//isCell               是否是电话
//isIDCard         是否是身份证
//isIP                  是否是IP
//isChinese()         是否是中文
//isQQ        是否是QQ
//isNum()    数字,整数
//isSplit(spliteStr,min,max) 被标志隔开
//isUrl  是否是url
//isHtml 是否是hTML
//isFloat(length) 是否是浮点   length小数长度
//notContains(string...) 是否包含指定数值
//equals - 与指定内容相同
//notEquals - 与指定内容不相同


//默认验证
//required()	Boolean	必填验证元素。
//required(dependency-expression)	Boolean	必填元素依赖于表达式的结果。
//required(dependency-callback)	Boolean	必填元素依赖于回调函数的结果。
//remote(url)	Boolean	请求远程校验。url 通常是一个远程调用方法。
//minlength(length)	Boolean	设置最小长度。
//maxlength(length)	Boolean	设置最大长度。
//rangelength(range)	Boolean	设置一个长度范围 [min,max]。
//min(value)	Boolean	设置最小值。
//max(value)	Boolean	设置最大值。
//email()	Boolean	验证电子邮箱格式。
//range(range)	Boolean	设置值的范围。
//url()	Boolean	验证 URL 格式。
//date()	Boolean	验证日期格式（类似 30/30/2008 的格式，不验证日期准确性只验证格式）。
//dateISO()	Boolean	验证 ISO 类型的日期格式。
//dateDE()	Boolean	验证德式的日期格式（29.04.1994 或 1.1.2006）。
//number()	Boolean	验证十进制数字（包括小数的）。
//digits()	Boolean	验证整数。
//creditcard()	Boolean	验证信用卡号。
//accept(extension)	Boolean	验证相同后缀名的字符串。
//equalTo(other)	Boolean	验证两个输入框的内容是否相同。
//phoneUS()	Boolean	验证美式的电话号码。

(function (jQuery) {

//自定义集合
    jQuery.validateRules = {
        isEmail: {
            handler: function (value, express) {
                return new RegExp("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$").test(value);
            },
            message: '请输入正确的邮箱'
        },
        isCell: {
            handler: function (value) {
                return new RegExp("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$").test(value)
            },
            message: '请输入正确的手机'
        }
        ,
        isIDCard: {
            handler: function (value) {
                return new RegExp("^\\d{15}|\\d{18}$").test(value)
            },
            message: ''
        },
        isIP: {
            handler: function () {
                return new RegExp("^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$").test(this)
            },
            message: '请输入正确的身份证'
        },
        isChinese: {
            handler: function (value, min, max) {
                var reg = "";
                reg = "^[\\u4e00-\\u9fa5]*$";
                return new RegExp(reg).test(value)
            },
            message: ''
        },
        isQQ: {
            handler: function (value) {
                return new RegExp("^[1-9][0-9]{4,}$").test(value)
            },
            message: '请输入正确的QQ'
        },
        isNum: {
            handler: function (value, min, max) {
                var reg = "";
                reg = "^\\d*$";
                return new RegExp(reg).test(value)
            },
            message: ''
        },
        isSplit: {
            handler: function (value, splitStr, min, max) {
                var reg = "";
                reg = "^(((\\w||[\\u4e00-\\u9fa5])+[" + splitStr + "])||(\\w||[\\u4e00-\\u9fa5])+){" + min + "," + max + "}$";
                return new RegExp(reg).test(value)
            },
            message: '请输入正确的QQ'
        }
        ,
        isUrl: {
            handler: function (value) {
                return new RegExp("^((https||http||ftp||rtsp||mms)?:\\/\\/)[^\\s]+").test(value)
            },
            message: ''
        },
        notHTML: {
            handler: function (value) {
                return new RegExp("<.*?(>|(/>))(.*?<.*?>)?").test(value);
            },
            message: '不能输入HTML'
        },
        isFloat: {
            handler: function (value, decimalLength) {
                var reg = '';
                if (decimalLength != null) {
                    reg = '^\\d*?[.]\\d{' + decimalLength + '}$';
                } else {
                    reg = '^\\d*?[.]\\d*$';
                }
                return new RegExp(reg).test(value)
            },
            message: '请输入正确的小数'
        },
        notContains: {
            handler: function (value, array) {
                for (var i = 0; i < array.length; i++) {
                    var obj = array[i];
                    if (value.indexOf(obj) > -1) {
                        return false;
                    }
                }
                return true;
            },
            message: '不能包含指定字符'
        },
        equals: {
            handler: function (value, value1) {
                return value == value1;
            },
            message: "必须为{0}"
        },
        notEquals: {
            handler: function (value, value1) {
                return value != value1;
            },
            message: "不能为{0}"
        }
    }


//自定义添加
    for (var name in jQuery.validateRules) {
        (function (name, obj) {
            jQuery.validator.addMethod(name, function (value, element, param) {
                if (typeof (param) == 'string') {//看看是不是字符串
                    if (param == 'true') {
                        param = []
                    } else if (/^\[.*\]$/.test(param)) {
                        param = eval(param.replace(/[']/gi, '"'));
                    }
                } else if (!(param instanceof Array)) {
                    param = [param]
                }
                var para = [value];
                for (var j = 0; j < param.length; j++) {
                    para.push(param[j])
                }
                1
                return (this.optional(element) || (obj.handler.apply(null, para)))
            }, obj.message === '' ? 'error' : obj.message)
        })(name, jQuery.validateRules[name])
    }


//默认设置
    jQuery.validator.setDefaults({
        success: function (label) {//成功之后的提示
            label.text("Ok!").addClass("valid")
        },
        //onkeyup: false,//关闭按键抬起的验证
        //onclick: false,//关闭点击的验证
        //focusInvalid: false,//关闭关注的验证
        //onsubmit: false,//关闭提交的验证
        //onfocusout: false,//关闭失去关注的验证
        //focusCleanup: true,//注目的时候是否清除信息提示
        errorClass: "invalid",//验证失败的class名  默认invalid
        validClass: "valid"//验证成功的class名   默认valid
        //errorElement: "em",//提示框的标签类型 默认label
        //wrapper: "li",//提示框包裹标签
    });

})(jQuery)
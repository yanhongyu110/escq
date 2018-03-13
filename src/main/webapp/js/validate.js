/*
 * 用途：检查输入字符串是否为空或者全部都是空格 输入：param 返回： 如果全是空返回true,否则返回false
 */ 
function checkNull(param){
	param = space(param);
	if (param == ""){
		return true; 
	}
	var regu = "^[ ]+$";
	var re = new RegExp(regu); 
	return re.test(param); 
} 
/*
 * 用途：检查输入字符串的长度,param为参数,min为最小长度,max最大长度
 */
function checkLength(param,min,max){
	param = space(param);
	if(param.length>max){
		return true;
	}
	if(param.length<min){
		return true;
	}
	return false;
}
/*
 * 用途：检查输入对象是否为手机 输入：param 输入的字符串 返回：如果通过验证返回true,否则返回false
 */ 
function checkCell(param){
	param = space(param);
	var regu = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
	var re = new RegExp(regu); 
	return regu.test(param); 
}
/*
 * 用途：检查输入对象手否为座机(正确的格式为：023-xxxxxxxx或者0231-xxxxxxx)  输入：param 输入的字符串 返回：如果通过验证返回true,否则返回false
 */ 
function checkPhone(param){
	param = space(param);
	var regu = /\d{3}-\d{8}|\d{4}-\d{7}/; 
	var re = new RegExp(regu); 
	return regu.test(param); 
}
/*
 * 用途：检查输入对象手否为email  输入：param 输入的字符串 返回：如果通过验证返回true,否则返回false
 */ 
function checkEmail(param){
	param = space(param);
	var regu = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
	var re = new RegExp(regu); 
	return regu.test(param); 
}
/*
 * 用途：检查输入字符串是否符合正整数格式 输入： param：字符串 返回： 如果通过验证返回true,否则返回false
 */ 
function checkIsallNum(param){ 
	param = space(param);
	var a = parseInt(param.substring(0,1));
	var regu = "^[0-9]+$"; 
	var re = new RegExp(regu); 
	if (param.search(re) != -1 && parseInt(param.substring(0,1)) != 0) { 
		return true; 
	}else{ 
		return false; 
	} 
}
/*
 * 用途：检查输入字符串是否只由英文字母和数字组成 输入： param：字符串 返回： 如果通过验证返回true,否则返回false
 */ 
function checkNumAndChar(param){
	param = space(param);
	var regu = "^[0-9a-zA-Z]+$"; 
	var re = new RegExp(regu); 
	if (re.test(param)) { 
		return true; 
	}else{ 
		return false; 
	} 
}
/*
 * 用途：检查输入字符串是否符合金额格式 格式定义为带小数的正数，小数点后最多二位 输入： param：字符串 返回： 如果通过验证返回true,否则返回false
 */
function checkFolat(param){
	param = space(param);
	var regu = "^[0-9]+[\.][0-9]{0,2}$"; 
	var re = new RegExp(regu); 
	if (re.test(param)) { 
		return true; 
	}else if(checkIsallNum(param)){ 
		return true; 
	}else{
		return false;
	}
}
/*
 * 用途：去掉字符所有空格
 */ 
function space(param){
	return param.replace(/\s/g, "");
}
/*
 * 用途：用于验证工作年限 0-50
 */ 
function workYear(param){
	param = space(param);
	var regu = /^([0-9]|[1-4]+[0-9])$/; 
	var re = new RegExp(regu); 
	if (re.test(param)) { 
		return true; 
	}else{ 
		return false; 
	} 
}
/*
 * 用途：用于关键字 用逗号分开   不能超过5个
 */ 
function keyWords(param){
	param = space(param);
	var regu = /^(((\w||[\u4e00-\u9fa5])+[,])||(\w||[\u4e00-\u9fa5])+){0,5}$/; 
	var re = new RegExp(regu); 
	if (re.test(param)) { 
		return true; 
	}else{ 
		return false; 
	} 
}
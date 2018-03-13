/**
 * Created by blazh on 2016/12/7.
 */


var validateType = {
    EMAIL: "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",
    CELL: "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",
    PASSID: "^\\d{15}|\\d{18}$",
    IP: "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$",
    CHINESE: "^[\\u4e00-\\u9fa5]*$",
    QQ: "^[1-9][0-9]{4,}$",
    INTEGER:"^(?:0|[1-9][0-9]?)$"
}




angular.module("fastValidate", []).directive("validateType", function () {
    return {
        require: "ngModel",
        link: function (scope, element, attr, ngModel) {
            ngModel.$parsers.push(function (r) {
                var bool = new RegExp(validateType[attr.validateType]).test(r)
                ngModel.$setValidity(attr.validateType, bool);
                return r;
            })
        }
    };
})





/**
 * Created by blazh on 2016/12/12.
 */


function pageModel(list, totalSize, page, pageSize, btnSize) {
    this.list = list || null
    this.totalSize =parseInt(totalSize)|| 0;
    this.pageSize = parseInt(pageSize) || 10;
    this.page = parseInt(page) || 1;
    this.totalPage = parseInt(Math.ceil(totalSize / pageSize));
    this.btnList = []
    this.btnSize=parseInt(btnSize)||5;
    this.filter='';
    if (list != null) {
        if (this.page - (this.btnSize + 1) / 2 < 0) {
            for (var i = 1; i <= ((this.btnSize > this.totalPage) ? this.totalPage : this.btnSize); i++) {
                this.btnList.push({index: i});
            }
        } else if (this.page - (this.btnSize + 1) / 2 > this.totalPage) {
            for (var i = this.btnSize > (this.totalPage ? 1 : this.totalPage - this.btnSize); i <= this.totalPage; i++) {
                this.btnList.push({index: i});
            }
        } else {
            for (var i = this.page - (this.btnSize - 1) / 2; i <= this.page + (this.btnSize - 1) / 2; i++) {
                this.btnList.push({index: i});
            }
        }
    }
}




angular.module("fastPage", []).directive("pageConfig", function () {
    return {
        restrict: 'E',
        replace:true,
        template:"<div style='display: none'></div>",
        scope: false,
        link: function (scope, element, attr, ngController) {
            scope.getPageList = function () {
            	console.log(scope.pageCon)
                $.ajax({
                    url: attr.url,
                    data: {
                        page: scope.page.page,
                        pageSize: scope.page.pageSize,
                        con:JSON.stringify(scope.pageCon)
                    },
                    type: "post",
                    success: function (_re) {
                    	var re=JSON.parse(_re);
                        scope.page = new pageModel(re.list, re.totalSize, re.page, re.pageSize,scope.btnSize);
                        scope.$apply()
                    }
                })
            }
            scope.goToPage = function (i) {
                if (i <= scope.page.totalPage && i >= 1) {
                    scope.page.page = i;
                    scope.getPageList()
                } else {
                    alert("超出范围域")
                }
            }

            var _page = attr.page;
            var pageSize = attr.pageSize;
            var btnSize = attr.btnSize;
            scope.btnSize=btnSize;
            scope.page = new pageModel();
            scope.page.page = _page;
            scope.page.pageSize = pageSize;
            scope.pageCon={}
            scope.getPageList()
        }
    }
}).directive("url",function(){
    return{
        require:"?^pageConfig",
    }
}).directive("pageSize",function(){
    return{
        require:"?^pageConfig"
    }
}).directive("page",function(){
    return{
        require:"?^pageConfig"
    }
}).directive("btnSize",function(){
    return{
        require:"?^pageConfig"
    }
}).directive("nextPage", function () {
    return {
        restrict: 'A',
        scope: false,
        link: function (scope, element, attr, ngController) {
            element.bind("click", function ($) {
                var page = scope.page;
                if (page.page + 1 > page.totalPage) {
                    alert("超出页数范围")
                } else {
                    scope.getPageList()
                }
            })
        }
    }
}).directive("prevPage", function () {
    return {
        restrict: 'A',
        scope: false,
        link: function (scope, element, attr, ngController) {
            element.bind("click", function ($) {
                var page = scope.page;
                if (page.page - 1 < 0) {
                    alert("超出页数范围")
                } else {
                    scope.getPageList()
                }
            })
        }
    }
}).directive("pageInput", function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr, ngController) {

            scope.$watch('page.page',function(newVal,oldVal,scope){
                element.val(newVal)
                scope.pageInput = newVal;
            },true)


            element.bind("blur",function(){
                if (/^\s*$/.test(this.value)){
                    this.value=1;
                    scope.pageInput = "1";
                    scope.$apply()
                }
            })
            element.bind("keyup",function (value) {
                var page = scope.page;
                var i = parseInt(this.value)
              if (i <= 0) {
                    this.value=1;
                    scope.pageInput = "1";
                }else if (i>page.totalPage){
                    this.value=page.totalPage;
                    scope.pageInput = page.totalPage;
                }else {
                    scope.pageInput = i;
                }
                scope.$apply()
            })
        }
    }
}).directive("pageInputBtn", function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr, ngController) {
            element.bind("click", function () {
                scope.goToPage(scope.pageInput)
            })
        }
    }
}).directive("pageCon", function () {
    return {
        restrict: 'A',
        require: "ngModel",
        link: function (scope, element, attr, ngController) {
            ngController.$parsers.push(function (value) {
                scope.pageCon[attr.pageCon] = value;
                return value;
            })
        }
    }
}).directive("pageIndexBtn", function () {
    return {
        restrict: 'A',
        scope: false,
        link: function (scope, element, attr, ngController) {
            element.bind("click", function () {
                scope.goToPage(scope.$index + 1)
            })
            element.css("cursor", "pointer")
        }
    }
}).directive("pageSizeSelect", function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr, ngController) {
            scope.$watch("page.pageSize",function(newVal,odlVal,scope){
                element.val(newVal+'')
                console.log(newVal)
            },true)
            element.bind("change", function () {
                scope.page.pageSize=parseInt(this.value)
                scope.$apply()
                scope.getPageList();
            })
        }
    }
}).directive("pageIndexBtn", function () {
    return {
        restrict: 'A',
        scope: false,
        link: function (scope, element, attr, ngController) {
            element.bind("click", function () {
                scope.goToPage(scope.$index + 1)
            })
            element.css("cursor", "pointer")
        }
    }
}).directive("pageFirst", function () {
    return {
        restrict: 'A',
        scope: false,
        link: function (scope, element, attr, ngController) {
            element.bind("click", function () {
                scope.goToPage(1)
            })
            element.css("cursor", "pointer")
        }
    }
}).directive("pageLast", function () {
    return {
        restrict: 'A',
        scope: false,
        link: function (scope, element, attr, ngController) {
            element.bind("click", function () {
                scope.goToPage(scope.page.totalPage)
            })
            element.css("cursor", "pointer")
        }
    }
})
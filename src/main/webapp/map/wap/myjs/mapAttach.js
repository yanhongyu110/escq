
//为了对全局变量进行智能感知,定义全局变量时尚未载入百度脚本,初始化必然报错,因此,先创建同名的类,
//百度脚本载入后,会自动覆盖

BMap = {};
BMap.Map = function () { };
BMap.Point = function () { };
BMap.Pixel = function () { };
BMap.Bounds = function () { };
BMap.Size = function () { };
BMap.Control = function () { };
BMap.OverviewMapControl = function () { };
BMap.MapTypeControl = function () { };
BMap.NavigationControl = function () { };
BMap.CopyrightControl = function () { };
BMap.ScaleControl = function () { };
BMap.GeolocationControl = function () { };
BMap.PanoramaControl = function () { };
BMap.Polyline = function () { };
BMap.Marker = function () { };
BMap.InfoWindow = function () { };
BMap.Hotspot = function () { };
BMap.Polygon = function () { };
BMap.Label = function () { };
BMap.Icon = function () { };
BMap.Circle = function () { };
BMap.MenuItem = function () { };
BMap.ContextMenu = function () { };
//定义事件名称
var BMapEventName =
{
    click: "click",
    dblclick: "dblclick",
    rightclick: "rightclick",
    rightdblclick: "rightdblclick",
    maptypechange: "maptypechange",
    mousemove: "mousemove",
    mouseover: "mouseover",
    mouseout: "mouseout",
    movestart: "movestart",
    moving: "moving",
    moveend: "moveend",
    zoomstart: "zoomstart",
    zoomend: "zoomend",
    addoverlay: "addoverlay",
    addcontrol: "addcontrol",
    removecontrol: "removecontrol",
    removeoverlay: "removeoverlay",
    clearoverlays: "clearoverlays",
    dragstart: "dragstart",
    dragging: "dragging",
    dragend: "dragend",
    addtilelayer: "addtilelayer",
    removetilelayer: "removetilelayer",
    load: "load",
    resize: "resize",
    hotspotclick: "hotspotclick",
    hotspotover: "hotspotover",
    hotspotout: "hotspotout",
    tilesloaded: "tilesloaded",
    touchstart: "touchstart",
    touchmove: "touchmove",
    touchend: "touchend",
    longpress: "longpress"
};

var BMapControlEventName =
{
    viewchanged: "viewchanged",
    viewchanging: "viewchanging"
};

var BMapGeolocationEventName =
{
    locationSuccess: "locationSuccess",
    locationError: "locationError"
};
var BMapPolylineEventName =
{
    click: "click",
    dblclick: "dblclick",
    mousedown: "mousedown",
    mouseup: "mouseup",
    mouseout: "mouseout",
    mouseover: "mouseover",
    remove: "remove",
    lineupdate: "lineupdate"
};


var BMapMarkerEventName =
{
    click: "click",
    dblclick: "dblclick",
    mousedown: "mousedown",
    mouseup: "mouseup",
    mouseout: "mouseout",
    mouseover: "mouseover",
    remove: "remove",
    infowindowclose: "infowindowclose",
    infowindowopen: "infowindowopen",
    dragstart: "dragstart",
    dragging: "dragging",
    dragend: "dragend",
    rightclick: "rightclick"
};

var BMapInfoWindowEventName =
{
    close: "close",
    open: "open",
    maximize: "maximize",
    restore: "restore",
    clickclose: "clickclose"
};

var BMapPolygonEventName =
{
    click: "click",
    dblclick: "dblclick",
    mousedown: "mousedown",
    mouseup: "mouseup",
    mouseout: "mouseout",
    mouseover: "mouseover",
    remove: "remove",
    lineupdate: "lineupdate"
};

var BMapLabelEventName =
{
    click: "click",
    dblclick: "dblclick",
    mousedown: "mousedown",
    mouseup: "mouseup",
    mouseout: "mouseout",
    mouseover: "mouseover",
    remove: "remove",
    rightclick: "rightclick"
};

var BMapCircleEventName =
{
    click: "click",
    dblclick: "dblclick",
    mousedown: "mousedown",
    mouseup: "mouseup",
    mouseout: "mouseout",
    mouseover: "mouseover",
    remove: "remove",
    lineupdate: "lineupdate"
};
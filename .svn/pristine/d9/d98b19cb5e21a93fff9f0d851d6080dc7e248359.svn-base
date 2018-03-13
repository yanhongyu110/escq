//==============常量定义=================

var 
//ControlAnchor:表示控件的定位
    BMAP_ANCHOR_TOP_LEFT, // 表示控件定位于地图的左上角。
    BMAP_ANCHOR_TOP_RIGHT, // 表示控件定位于地图的右上角。
    BMAP_ANCHOR_BOTTOM_LEFT, // 表示控件定位于地图的左下角。
    BMAP_ANCHOR_BOTTOM_RIGHT, // 表示控件定位于地图的右下角。
//LengthUnit:表示长度单位制式
    BMAP_UNIT_METRIC, //	公制单位。
    BMAP_UNIT_IMPERIAL, //	英制单位。
//MapTypeControlType:此常量表示MapTypeControl的外观样式
    BMAP_MAPTYPE_CONTROL_HORIZONTAL, //	按钮水平方式展示，默认采用此类型展示。
    BMAP_MAPTYPE_CONTROL_DROPDOWN, //	按钮呈下拉列表方式展示。
//NavigationControlType:此常量表示平移缩放控件的类型
    BMAP_NAVIGATION_CONTROL_LARGE, //	标准的平移缩放控件（包括平移、缩放按钮和滑块）。
    BMAP_NAVIGATION_CONTROL_SMALL, //	仅包含平移和缩放按钮。
    BMAP_NAVIGATION_CONTROL_PAN, //仅包含平移按钮。
    BMAP_NAVIGATION_CONTROL_ZOOM, //	仅包含缩放按钮。
//描述对象当前状态
    BMAP_STATUS_PERMISSION_DENIED, //	没有权限。对应数值“6”。(自 1.1 新增)
    BMAP_STATUS_SERVICE_UNAVAILABLE, //	服务不可用。对应数值“7”。(自 1.1 新增)
    BMAP_STATUS_TIMEOUT, //	超时。对应数值“8”。(自 1.1 新增)
//Animation:动画效果
    BMAP_ANIMATION_DROP, //坠落动画。
    BMAP_ANIMATION_BOUNCE, //跳动动画。
//版本
    BMAP_API_VERSION; //  String  返回当前 API 版本。例如，1.2版本返回字符串“1.2”。(自  1.2 新增)

//============核心类=========//
var BMap = {};
BMap.Map = function (container, opts)
{
    ///	<summary>
    ///	在指定的容器内创建地图实例，之后需要调用Map.centerAndZoom()方法对地图进行初始化。未进行初始化的地图将不能进行任何操作。
    ///	</summary> 
    /// <param name="container" type="String">加载百度地图的控件ID,通常是一个div,也可以直接是一个js控件对象</param>
    /// <param name="opts" type="MapOptions">可选参数</param>
};

//---------配置方法--------
BMap.Map.prototype.enableDragging = function ()
{
    ///	<summary>
    ///	启用地图拖拽，默认启用。
    ///	</summary> 
};

BMap.Map.prototype.disableDragging = function ()
{
    ///	<summary>
    ///	禁用地图拖拽。
    ///	</summary> 
};
BMap.Map.prototype.enableScrollWheelZoom = function ()
{
    ///	<summary>
    ///	启用滚轮放大缩小，默认禁用。
    ///	</summary> 
};
BMap.Map.prototype.disableScrollWheelZoom = function ()
{
    ///	<summary>
    ///	禁用滚轮放大缩小。 
    ///	</summary> 
};
BMap.Map.prototype.enableDoubleClickZoom = function ()
{
    ///	<summary>
    ///	启用双击放大，默认启用。 
    ///	</summary> 
};
BMap.Map.prototype.disableDoubleClickZoom = function ()
{
    ///	<summary>
    ///	 禁用双击放大。 
    ///	</summary> 
};
BMap.Map.prototype.enableKeyboard = function ()
{
    ///	<summary>
    ///	启用键盘操作，默认禁用。键盘的上、下、左、右键可连续移动地
    ///图。同时按下其中两个键可使地图进行对角移动。PgUp、PgDn、
    ///Home 和 End 键会使地图平移其1/2的大小。+、-键会使地图放大或
    ///缩小一级。 
    ///	</summary> 
};
BMap.Map.prototype.disableKeyboard = function ()
{
    ///	<summary>
    ///	禁用键盘操作。
    ///	</summary> 
};
BMap.Map.prototype.enableInertialDragging = function ()
{
    ///	<summary>
    ///	  启用地图惯性拖拽，默认禁用。(自  1.1 新增) 
    ///	</summary> 

};
BMap.Map.prototype.disableInertialDragging = function ()
{
    ///	<summary>
    ///	禁用地图惯性拖拽。 (自  1.1 新增)
    ///	</summary> 
};
BMap.Map.prototype.enableContinuousZoom = function ()
{
    ///	<summary>
    ///	
    ///	</summary> 
};
BMap.Map.prototype.disableContinuousZoom = function ()
{
    ///	<summary>
    ///	禁用连续缩放效果。 (自  1.1 新增) 
    ///	</summary> 
};
BMap.Map.prototype.enablePinchToZoom = function ()
{
    ///	<summary>
    ///	启用双指操作缩放，默认启用。 (自  1.1 新增)
    ///	</summary> 
};
BMap.Map.prototype.disablePinchToZoom = function ()
{
    ///	<summary>
    ///	 禁用双指操作缩放。 (自  1.1 新增) 
    ///	</summary> 
};
BMap.Map.prototype.enableAutoResize = function ()
{
    ///	<summary>
    ///	启用自动适应容器尺寸变化，默认启用。(自  1.2 新增)
    ///	</summary> 
};
BMap.Map.prototype.disableAutoResize = function ()
{
    ///	<summary>
    ///	禁用自动适应容器尺寸变化。 (自  1.2 新增) 
    ///	</summary> 
};
BMap.Map.prototype.setDefaultCursor = function (cursor)
{
    ///	<summary>
    ///	 设置地图默认的鼠标指针样式。参数 cursor 应符合 CSS的 cursor属性规范。 (自  1.1 新增) 
    ///	</summary> 
    /// <param name="cursor" type="String">鼠标样式,应符合 CSS的 cursor属性规范。</param>
};
BMap.Map.prototype.getDefaultCursor = function ()
{
    ///	<summary>
    ///	返回地图默认的鼠标指针样式。 (自  1.1 新增)
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Map.prototype.setDraggingCursor = function (cursor)
{
    ///	<summary>
    ///	设置拖拽地图时的鼠标指针样式。参数cursor应符合CSS的cursor属性规范。 (自  1.1 新增) 
    ///	</summary> 
    /// <param name="cursor" type="String">鼠标样式,应符合 CSS的 cursor属性规范。</param>
}

BMap.Map.prototype.getDraggingCursor = function ()
{
    ///	<summary>
    ///	返回拖拽地图时的鼠标指针样式。 (自  1.1 新增) 
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Map.prototype.setMinZoom = function (zoom)
{
    ///	<summary>
    ///	 设置地图允许的最小级别。取值不得小于地图类型所允许的最小级别。(自  1.2 新增)
    ///	</summary> 
    /// <param name="zoom" type="Number">地图允许的最小级别</param>
};

BMap.Map.prototype.setMaxZoom = function (zoom)
{
    ///	<summary>
    ///	  设置地图允许的最大级别。取值不得大于地图类型所允许的最大级别。 (自  1.2 新增) 
    ///	</summary> 
    /// <param name="zoom" type="Number">地图允许的最小级别</param>
};

//2.---------地图状态方法---------
BMap.Map.prototype.getBounds = function ()
{
    ///	<summary>
    ///	返回地图可视区域，以地理坐标表示。 
    ///	</summary> 
    ///	<returns type="BMap.Bounds" />

};

BMap.Map.prototype.getCenter = function ()
{
    ///	<summary>
    ///	 返回地图当前中心点。
    ///	</summary> 
    ///	<returns type="BMap.Point" />

};

BMap.Map.prototype.getDistance = function (start, end)
{
    ///	<summary>
    ///	  返回两点之间的距离，单位是米。(自  1.1 新增) 
    ///	</summary> 
    /// <param name="start" type="BMap.Point"></param>
    /// <param name="end" type="BMap.Point"></param>
    ///	<returns type="Number" />
};

BMap.Map.prototype.getMapType = function ()
{
    ///	<summary>
    ///	返回地图类型。(自  1.2 新增) 
    ///	</summary> 
    ///	<returns type="BMap.MapType" />
};

BMap.Map.prototype.getSize = function ()
{
    ///	<summary>
    ///	返回地图视图的大小，以像素表示。 
    ///	</summary> 
    ///	<returns type="BMap.Size" />
};

BMap.Map.prototype.getViewport = function (view, viewportOptions)
{
    ///	<summary>
    ///	根据提供的地理区域或坐标获得最佳的地图视野，返
    ///	回的对象中包含 center 和 zoom 属性，分别表示地
    ///	图的中心点和级别。此方法仅返回视野信息，不会将
    ///	新的中心点和级别做用到当前地图上。 (自  1.1 新增)   
    ///	</summary> 
    /// <param name="view" type=" Array<Point>">提供的地理区域或坐标获</param>
    /// <param name="viewportOptions" type="ViewportOptions">可选,选项</param>
    ///	<returns type="BMap.Viewport" />
};

BMap.Map.prototype.getZoom = function ()
{
    ///	<summary>
    ///	  返回地图当前缩放级别。
    ///	</summary> 
    ///	<returns type="Number" />
};


//3.---------地图的方法----------
BMap.Map.prototype.centerAndZoom = function (center, zoom)
{
    ///	<summary>
    ///	设初始化地图,并将地图移动到指定的位置
    ///	</summary> 
    /// <param name="center" type="BMap.Point">设置当前地图中心点坐标,通常为一个BMap.Point,
    /// 如果 center 类型为字符串时，比如“北京”，zoom可以忽略，地图将自动根据 center 调整 zoom 级别。</param>
    ///  <param name="zoom" type="Number">地图缩放级别</param>
};
BMap.Map.prototype.panTo = function (center, opts)
{
    ///	<summary>
    ///	将地图的中心点更改为给定的点。如果该点在当前
    /// 的地图视图中已经可见，则会以平滑动画的方式移
    /// 动到中心点位置。可以通过配置强制移动过程不使
    /// 用动画效果。
    ///	</summary> 
    /// <param name="center" type="BMap.Point">新的中心点坐标</param>
    /// <param name="opts" type="PanOptions">该参数可选,可以通过配置强制移动过程不使用动画效果</param>
};
BMap.Map.prototype.panBy = function (x, y, opts)
{
    ///	<summary>
    ///	将地图在水平位置上移动 x像素，垂直位置上移动
    /// y像素。如果指定的像素大于可视区域范围或者在
    /// 配置中指定没有动画效果，则不执行滑动效果。 
    ///	</summary> 
    /// <param name="x" type="Number">水平位置上移动 x像素</param>
    /// <param name="y" type="Number">垂直位置上移动 y像素</param>
    /// <param name="opts" type="PanOptions">可选参数,选项</param>
};
BMap.Map.prototype.reset = function ()
{
    ///	<summary>
    ///	重新设置地图，恢复地图初始化时的中心点和级别。 
    ///	</summary> 
};
BMap.Map.prototype.setCenter = function (center)
{
    ///	<summary>
    ///	 设置地图中心点。center 除了可以为坐标点以外，还支持城市名。  
    ///	</summary> 
    /// <param name="center" type="BMap.Point">中心点坐标,也可以是城市名称</param>
};
BMap.Map.prototype.setCurrentCity = function (city)
{
    ///	<summary>
    ///	设置地图城市，注意当地图初始化时的类型设置为
    ///	BMAP_PERSPECTIVE_MAP 时，需要在调用
    ///	centerAndZoom 之前调用此方法设置地图所在城
    ///	市。例如： 
    ///	var map = new BMap.Map(“container”, 
    ///	{mapType: BMAP_PERSPECTIVE_MAP}); 
    ///	map.setCurrentCity(“北京市”); 
    ///	map.centerAndZoom(new BMap.Point(116.404, 
    ///	39.915), 18); 注意：初始化的坐标应与您设置的城
    ///	市对应，否则地图将无法正常显示。如果地图初始
    ///	化为 BMAP_NORMAL_MAP 类型，则在调用
    ///	setMapType 切换地图类型时也要调用此方法。 (自 
    ///	1.1 新增) 
    ///	</summary> 
    /// <param name="city" type="String">城市名称</param>
};

BMap.Map.prototype.setMapType = function (mapType)
{
    ///	<summary>
    ///	设置地图类型。注意，当设置地图类型为
    /// BMAP_PERSPECTIVE_MAP 时，需要调用
    /// map.setCurrentCity 方法设置城市。(自  1.1 新增) 
    ///	</summary> 
    /// <param name="mapType" type="BMap.MapTypes"></param>
};


BMap.Map.prototype.setViewport = function (view, viewportOptions)
{
    ///	<summary>
    ///	根据提供的地理区域或坐标设置地图视野，调整后
    ///	的视野会保证包含提供的地理区域或坐标。(自 1.1 新增)   
    ///	</summary> 
    /// <param name="view" type="Array<Point>"></param>
    /// <param name="viewportOptions" type="ViewportOptions>">可选选项</param>
};

BMap.Map.prototype.setZoom = function (zoom)
{
    ///	<summary>
    ///	将视图切换到指定的缩放等级，中心点坐标不变。
    ///	注意：当有信息窗口在地图上打开时，地图缩放将
    ///	保证信息窗口所在的坐标位置不动。（自1.2新增） 
    ///	</summary> 
    /// <param name="zoom" type="Number">缩放等级</param>
};

BMap.Map.prototype.highResolutionEnabled = function ()
{
    ///	<summary>
    ///	 是否使用高分辨率底图。仅当mapOptions.enableHighResolution属性为true且设备支持高分辨率时返回 true。 
    ///	</summary> 
    ///	<returns type="Boolean" />
};


BMap.Map.prototype.zoomIn = function ()
{
    ///	<summary>
    ///	放大一级视图。  
    ///	 </summary> 
};

BMap.Map.prototype.zoomOut = function ()
{
    ///	<summary>
    ///	缩小一级视图。  
    ///	 </summary> 
};
BMap.Map.prototype.addHotspot = function (hotspot)
{
    ///	<summary>
    ///	 为地图添加热区。(自  1.2 新增)  
    ///	</summary> 
    /// <param name="hotspot" type="BMap.Hotspot">热区</param>
};

BMap.Map.prototype.removeHotspot = function (hotspot)
{
    ///	<summary>
    ///	 移除某个地图热区。(自  1.2 新增) (自  1.2 新增)  
    ///	</summary> 
    /// <param name="hotspot" type="BMap.Hotspot">热区</param>  
};

BMap.Map.prototype.clearHotspots = function ()
{
    ///	<summary>
    ///	清空地图所有热区。(自  1.2 新增)   
    ///	</summary> 
};
//4.-----控件方法-------------
BMap.Map.prototype.addControl = function (control)
{
    ///	<summary>
    ///	将控件添加到地图，一个控件实例只能向地图中添加一次。  
    ///	</summary> 
    /// <param name="control" type="BMap.Control">需要添加的控件</param>
};

BMap.Map.prototype.removeControl = function (control)
{
    ///	<summary>
    ///	从地图中移除控件。如果控件从未被添加到地图中，则该移除不起任何作用。  
    ///	</summary> 
    /// <param name="control" type="BMap.Control">需要移除的控件</param>
};

BMap.Map.prototype.getContainer = function ()
{
    ///	<summary>
    ///	返回地图的容器元素。当创建用户自定义控件时，需要自行实现
    /// Control.initialize()方法，并将控件的容器元素添加到地图上，通过
    /// 此方法可获得地图容器。 
    ///	</summary> 
    ///	<returns type="HTMLElement" />
};
//5.-----右键菜单-----
BMap.Map.prototype.addContextMenu = function (menu)
{
    ///	<summary>
    ///	 添加右键菜单。 
    ///	</summary> 
    /// <param name="menu" type="BMap.ContextMenu">需要添加的右键菜单</param>
};
BMap.Map.prototype.removeContextMenu = function (menu)
{
    ///	<summary>
    ///	 移除右键菜单。 
    ///	</summary> 
    /// <param name="menu" type="BMap.ContextMenu">需要移除的右键菜单</param>
};
//6.-------覆盖物方法------
BMap.Map.prototype.addOverlay = function (overlay)
{
    ///	<summary>
    ///	将覆盖物添加到地图中，一个覆盖物实例只能向地图中添加一次。  
    ///	</summary> 
    /// <param name="overlay" type="BMap.Overlay">拟添加覆盖物</param>
};
BMap.Map.prototype.removeOverlay = function (overlay)
{
    ///	<summary>
    ///	 从地图中移除覆盖物。如果覆盖物从未被添加到地图中，则该移除不起任何作用。
    ///	</summary> 
    /// <param name="overlay" type="BMap.Overlay">拟移除的覆盖物</param>
};
BMap.Map.prototype.clearOverlays = function ()
{
    ///	<summary>
    /// 清除地图上所有覆盖物。 
    ///	</summary> 
};
BMap.Map.prototype.openInfoWindow = function (infoWnd, point)
{
    ///	<summary>
    ///	在地图上打开信息窗口。  
    ///	</summary> 
    /// <param name="infoWnd" type="BMap.InfoWindow">信息窗口</param>
    /// <param name="point" type="BMap.Point">显示的位置</param>
};
BMap.Map.prototype.closeInfoWindow = function ()
{
    ///	<summary>
    /// 关闭在地图上打开的信息窗口。在标注上打开的信息窗口也可通过此方法进行关闭。 
    ///	</summary> 
};
BMap.Map.prototype.getInfoWindow = function ()
{
    ///	<summary>
    ///	 返回地图上处于打开状态的信息窗的实例。当地图没有打开的信息窗口时，此方法返回null。(自 1.1 新增)
    ///	</summary> 
    ///	<returns type="BMap.InfoWindow" />
};
BMap.Map.prototype.getOverlays = function ()
{
    ///	<summary>
    ///	 返回地图上的所有覆盖物。(自 1.1 新增)
    ///	</summary> 
    ///	<returns type="Array<Overlay>" />
};
BMap.Map.prototype.getPanes = function ()
{
    ///	<summary>
    ///	 返回地图覆盖物容器列表。
    ///	</summary> 
    ///	<returns type="BMap.MapPanes" />
};
//7.---地图层方法-----
BMap.Map.prototype.addTileLayer = function (tileLayer)
{
    ///	<summary>
    ///	添加一个自定义地图图层。  
    ///	</summary> 
    /// <param name="tileLayer" type="BMap.TileLayer">需要添加的图层</param>
};
BMap.Map.prototype.removeTileLayer = function (tilelayer)
{
    ///	<summary>
    ///	 移除一个自定义地图图层。 
    ///	</summary> 
    /// <param name="tileLayer" type="BMap.TileLayer">需要移除的图层</param>
};
BMap.Map.prototype.getTileLayer = function (mapType)
{
    ///	<summary>
    ///	通过地图类型得到一个地图图层对象。  
    ///	</summary> 
    /// <param name="mapType" type="String">地图类型</param>
    ///	<returns type="BMap.TileLayer" />
};
//8.---------坐标转换-------
BMap.Map.prototype.pointToOverlayPixel = function (point)
{
    ///	<summary>
    ///	 根据地理坐标获取对应的覆盖物容器的坐标，此方法用于自定义覆盖物。(自 1.1 新增) 
    ///	</summary> 
    /// <param name="point" type="BMap.Point"></param>
    ///	<returns type="Pixel" />
};
BMap.Map.prototype.overlayPixelToPoint = function (pixel)
{
    ///	<summary>
    ///	 根据覆盖物容器的坐标获取对应的地理坐标。(自 1.1 新增)
    ///	</summary> 
    /// <param name="Pixel" type="Pixel"></param>
    ///	<returns type="BMap.Point" />
};
//9.---事件----
BMap.Map.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	 添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
BMap.Map.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	 移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
//定义事件的名称,在附加文件中具体实现
var BMapEventName =
{
    click: "click", //{type, target, point, pixel, overlay}左键单击地图时触发此事件。当双击时，产生的事件序列为： click click dblclick (自 1.1 更新)
    dblclick: "dblclick", //{type, target, pixel, point}鼠标双击地图时会触发此事件。
    rightclick: "rightclick", //{type, target, point, pixel, overlay}右键单击地图时触发此事件。当双击时，产生的事件序列为： rightclick rightclick rightdblclick (自 1.1 更新)
    rightdblclick: "rightdblclick", //{type, target, point, pixel, overlay}右键双击地图时触发此事件。(自 1.1 新增)
    maptypechange: "maptypechange", //{type, target}地图类型发生变化时触发此事件。(自 1.1 新增)
    mousemove: "mousemove", //{type, target, point, pixel, overlay}鼠标在地图区域移动过程中触发此事件。(自 1.1 新增)
    mouseover: "mouseover", //{type, target}鼠标移入地图区域时触发此事件。(自 1.2 新增)
    mouseout: "mouseout", //{type, target}鼠标移出地图区域时触发此事件。(自 1.2 新增)
    movestart: "movestart", //{type, target}地图移动开始时触发此事件。
    moving: "moving", //{type, target}地图移动过程中触发此事件。
    moveend: "moveend", //{type, target}地图移动结束时触发此事件。
    zoomstart: "zoomstart", //{type, target}地图更改缩放级别开始时触发触发此事件。
    zoomend: "zoomend", //{type, target}地图更改缩放级别结束时触发触发此事件。
    addoverlay: "addoverlay", //{type, target}当使用Map.addOverlay()方法向地图中添加单个覆盖物时会触发此事件。
    addcontrol: "addcontrol", //{type, target}当使用Map.addControl()方法向地图中添加单个控件时会触发此事件。
    removecontrol: "removecontrol", //{type, target}当使用Map.removeControl()方法移除单个控件时会触发此事件。
    removeoverlay: "removeoverlay", //{type, target}当使用Map.removeOverlay()方法移除单个覆盖物时会触发此事件。
    clearoverlays: "clearoverlays", //{type, target}当使用Map.clearOverlays()方法一次性移除全部覆盖物时会触发此事件。
    dragstart: "dragstart", //{type, target, pixel, point}开始拖拽地图时触发。
    dragging: "dragging", //{type, target, pixel, point}拖拽地图过程中触发。
    dragend: "dragend", //{type, target, pixel, point}停止拖拽地图时触发。
    addtilelayer: "addtilelayer", //{type, target}添加一个自定义地图图层时触发此事件。
    removetilelayer: "removetilelayer", //{type, target}移除一个自定义地图图层时触发此事件。
    load: "load", //{type, target, pixel, point, zoom}调用Map.centerAndZoom()方法时会触发此事件。这表示位置、缩放层级已经确定，但可能还在载入地图图块。
    resize: "resize", //{type, target, size}地图可视区域大小发生变化时会触发此事件。
    hotspotclick: "hotspotclick", //{type, target, spots}点击热区时触发此事件。(自 1.2 新增)
    hotspotover: "hotspotover", //{type, target, spots}鼠标移至热区时触发此事件。(自 1.2 新增)
    hotspotout: "hotspotout", //{type, target, spots}鼠标移出热区时触发此事件。(自 1.2 新增)
    tilesloaded: "tilesloaded", //{type, target}当地图所有图块完成加载时触发此事件。(自 1.2 新增)
    touchstart: "touchstart", //{type, target, point,pixel}触摸开始时触发此事件，仅适用移动设备。(自 1.5新增)
    touchmove: "touchmove", //{type, target, point,pixel}触摸移动时触发此事件，仅适用移动设备。(自 1.5新增)
    touchend: "touchend", //{type, target, point,pixel}触摸结束时触发此事件，仅适用移动设备。(自 1.5新增)
    longpress: "longpress"//{type, target, point,pixel}长按事件，仅适用移动设备。(自 1.5新增)	

};
//====基础类=====
//1.----地理坐标描述----
BMap.Point = function (lng, lat)
{
    ///	<summary>
    ///	以指定的经度和纬度创建一个地理点坐标
    ///	</summary> 
    /// <param name="lng" type="Number">地理经度。</param>
    /// <param name="lat" type="Number">地理纬度。</param>
};
BMap.Point.prototype.lng = {}; //	Number	地理经度。
BMap.Point.prototype.lat = {}; //	Number	地理纬度。
BMap.Point.prototype.equals = function (other)
{
    ///	<summary>
    ///	判断坐标点是否相等，当且仅当两点的经度和纬度均相等时返回true。  
    ///	</summary> 
    /// <param name="other" type="BMap.Point">用于比较的其他点</param>
    ///	<returns type="Boolean" />
};
BMap.Pixel = function (x, y)
{
    ///	<summary>
    ///	创建像素点对象实例。像素坐标的坐标原点为地图区域的左上角。
    ///	</summary> 
    /// <param name="x" type="Number">X坐标。</param>
    /// <param name="y" type="Number">Y坐标。</param>
};
BMap.Pixel.prototype.x = {}; //	Number	x坐标。
BMap.Pixel.prototype.y = {}; //	Number	y坐标。
BMap.Pixel.prototype.equals = function (other)
{
    ///	<summary>
    ///	判断坐标点是否相等，当且仅当两点的 x坐标和 y坐标均相等时返回true。
    ///	</summary> 
    /// <param name="other" type="BMap.Pixel">用于比较的其他像素</param>
    ///	<returns type="Boolean" />
};
//2.-----区域描述----------
BMap.Bounds = function (sw, ne)
{
    ///	<summary>
    ///	  创建一个包含所有给定点坐标的矩形区域。其中 sw表示矩
    /// 形区域的西南角，参数 ne 表示矩形区域的东北角。 
    /// (自  1.2 新增)
    ///	</summary> 
    /// <param name="sw" type="BMap.Point">矩形区域的西南角</param>
    /// <param name="ne" type="BMap.Point">矩形区域的东北角</param>
    ///	<returns type="String" />
};

BMap.Bounds.prototype.equals = function (other)
{
    ///	<summary>
    ///	 当且仅当此矩形中的两点参数都等于其他矩形的两点参数时，返回 true。  
    ///	</summary> 
    /// <param name="other" type="BMap.Bounds">用于比较的另外一个区域</param>
    ///	<returns type="Boolean" />
};
BMap.Bounds.prototype.containsPoint = function (point)
{
    ///	<summary>
    ///	  如果点的地理坐标位于此矩形内，则返回 true。 
    ///	</summary> 
    /// <param name="point" type="BMap.Point">用于计算的其他点</param>
    ///	<returns type="Boolean" />
};


BMap.Bounds.prototype.containsBounds = function (bounds)
{
    ///	<summary>
    ///	  传入的矩形区域完全包含于此矩形区域中，则返回 true。
    ///	</summary> 
    /// <param name="bounds" type="BMap.Bounds">传入的矩形区域</param>
    ///	<returns type="Boolean" />
};

BMap.Bounds.prototype.intersects = function (other)
{
    ///	<summary>
    ///	   计算与另一矩形的交集区域。 
    ///	</summary> 
    /// <param name="other" type="BMap.Bounds">另一矩形区域</param>
    ///	<returns type="BMap.Bounds" />
};

BMap.Bounds.prototype.extend = function (point)
{
    ///	<summary>
    ///	  放大此矩形，使其包含给定的点。
    ///	</summary> 
    /// <param name="point" type="BMap.Point">需要包含的点</param>
};
BMap.Bounds.prototype.getCenter = function ()
{
    ///	<summary>
    ///	  返回矩形的中心点。 
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};

BMap.Bounds.prototype.isEmpty = function ()
{
    ///	<summary>
    ///	 如果矩形为空，则返回 true。   
    ///	</summary> 
    ///	<returns type="Boolean" />
};

BMap.Bounds.prototype.getSouthWest = function ()
{
    ///	<summary>
    ///	 返回矩形区域的西南角。 (自  1.2 新增 )
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};

BMap.Bounds.prototype.getNorthEast = function ()
{
    ///	<summary>
    ///	 返回矩形区域的东北角。 (自  1.2 新增 )
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};

BMap.Bounds.prototype.toSpan = function ()
{
    ///	<summary>
    ///	 返回矩形区域的跨度 (自  1.2 新增 )
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};
//3.---描述宽度高度的对象
BMap.Size = function (width, height)
{
    ///	<summary>
    ///	  以指定的宽度和高度创建一个矩形区域大小对象。
    ///	</summary> 
    /// <param name="width" type="Number">水平方向数值。</param>
    /// <param name="height" type="Number">水平方向数值。</param>
};
BMap.Size.prototype.width = 0; //  水平方向数值。 
BMap.Size.prototype.height = 0; //  竖直方向的数值。

//===========控件类=========
BMap.Control = function ()
{
    ///	<summary>
    ///	  创建一个控件原型实例，通过该原型实例可创建自定义控件。
    ///	</summary> 
    /// <param name="cursor" type="String"></param>
    ///	<returns type="String" />
};

BMap.Control.prototype.defaultAnchor = {}; //	enum ControlAnchor	控件默认的停靠位置。自定义控件时需要提供此属性，作为控件的默认停靠位置。
BMap.Control.prototype.defaultOffset = {}; //	Size	控件默认的位置偏移值。自定义控件时需要提供此属性，作为控件的默认偏移位置。
BMap.Control.prototype.initialize = function (map)
{
    ///	<summary>
    ///	抽象方法。调用Map.addControl()方法添加控件时将调用此方法，从而实现该控件的初始化。自定义控件时需要实现此方法，并将元素的DOM元素在该方法中返回。DOM元素需要添加到地图的容器中，使用map.getContainer()方法可获得地图容器元素。  
    ///	</summary> 
    /// <param name="map" type="BMap.Map"></param>
    ///	<returns type="HTMLElement" />
};
BMap.Control.prototype.setAnchor = function (anchor)
{
    ///	<summary>
    ///	设置控件停靠的位置  
    ///	</summary> 
    /// <param name="anchor" type="ControlAnchor">停靠位置,如:BMAP_ANCHOR_TOP_LEFT</param>
};
BMap.Control.prototype.getAnchor = function ()
{
    ///	<summary>
    ///	返回控件停靠的位置,如:BMAP_ANCHOR_TOP_LEFT  
    ///	</summary> 
    ///	<returns type="ControlAnchor" />
};
BMap.Control.prototype.setOffset = function (offset)
{
    ///	<summary>
    ///	 设置控件停靠的偏移量 
    ///	</summary> 
    /// <param name="offset" type="BMap.Size"></param>
};
BMap.Control.prototype.getOffset = function ()
{
    ///	<summary>
    ///	 返回控件停靠的偏移量:BMap.Size
    ///	</summary> 
    ///	<returns type="BMap.Size" />
};
BMap.Control.prototype.show = function ()
{
    ///	<summary>
    ///	 显示控件
    ///	</summary>
};
BMap.Control.prototype.hide = function ()
{
    ///	<summary>
    ///	 隐藏控件
    ///	</summary>
};
BMap.Control.prototype.isVisible = function ()
{
    ///	<summary>
    ///	判断控件的可见性
    ///	</summary> 
    ///	<returns type="Boolean" />
};
BMap.Control.prototype.toString = function ()
{
    ///	<summary>
    ///	 返回描述类型字符串。如果需要，自定义控件需要自行实现此方法以获得描述自身类型的字符串。 
    ///	</summary> 
    ///	<returns type="String" />
};

BMap.Control.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	 添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
BMap.Control.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	 移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
//事件名称,具体在附加文件中实现
var BMapControlEventName =
{
    viewchanged: "viewchanged", //	event{type, target, isOpen}	缩略地图开合状态发生变化后触发此事件。
    viewchanging: "viewchanging"//	event{type, target}	缩略地图开合状态发生变化过程中触发此事件。
};

BMap.OverviewMapControl = function (opts)
{
    ///	<summary>
    ///	  创建一个缩略地图控件实例。
    ///	</summary> 
    /// <param name="opts" type="OverviewMapControlOptions">可选参数:选项</param>
};
BMap.OverviewMapControl.prototype.changeView = function ()
{
    ///	<summary>
    ///	 切换缩略地图控件的开合状态
    ///	</summary> 

};
BMap.OverviewMapControl.prototype.setSize = function (size)
{
    ///	<summary>
    ///	 设置缩略地图的大小 
    ///	</summary> 
    /// <param name="size" type="BMap.Size"></param>
};
BMap.OverviewMapControl.prototype.getSize = function ()
{
    ///	<summary>
    ///	 返回缩略地图的大小。 
    ///	</summary> 
    ///	<returns type="BMap.Size" />
};
BMap.MapTypeControl = function (opts)
{
    ///	<summary>
    ///	  创建地图类型控件。(自 1.1 新增)
    ///	</summary> 
    /// <param name="opts" type="MapTypeControlOptions">可选参数:选项</param>
};

BMap.NavigationControl = function (type)
{
    ///	<summary>
    ///	创建一个特定样式的地图平移缩放控件。  
    ///	</summary> 
    /// <param name="type" type="NavigationControlOptions">可选参数:选项</param>
};
BMap.NavigationControl.prototype.getType = function ()
{
    ///	<summary>
    ///	返回平移缩放控件的类型。
    ///	</summary> 
    ///	<returns type="NavigationControlType" />
};
BMap.NavigationControl.prototype.setType = function (type)
{
    ///	<summary>
    ///	设置平移缩放控件的类型。  
    ///	</summary> 
    /// <param name="type" type="NavigationControlType">控件的类型</param>
};

BMap.CopyrightControl = function (opts)
{
    ///	<summary>
    ///	创建一个版权控件实例。  
    ///	</summary> 
    /// <param name="opts" type="CopyrightControlOptions">可选,选项</param>
};
BMap.CopyrightControl.prototype.addCopyright = function (copyright)
{
    ///	<summary>
    ///	 添加版权信息。 
    ///	</summary> 
    /// <param name="copyright" type="Copyright">版权信息</param>
};
BMap.CopyrightControl.prototype.removeCopyright = function (id)
{
    ///	<summary>
    ///	移除版权信息。 
    ///	</summary> 
    /// <param name="id" type="Number">版权信息的唯一id</param>
};
BMap.CopyrightControl.prototype.getCopyright = function (id)
{
    ///	<summary>
    ///	返回单个版权信息。  
    ///	</summary> 
    /// <param name="id" type="Number">版权信息的唯一id</param>
    ///	<returns type="Copyright" />
};
BMap.CopyrightControl.prototype.getCopyrightCollection = function ()
{
    ///	<summary>
    ///	 返回版权信息列表。 
    ///	</summary> 
    ///	<returns type="Array<Copyright>" />
};
BMap.ScaleControl = function (opts)
{
    ///	<summary>
    ///	 创建一个比例尺控件。 
    ///	</summary> 
    /// <param name="opts" type="ScaleControlOptions">可选参数</param>
};
BMap.ScaleControl.prototype.getUnit = function ()
{
    ///	<summary>
    ///	 返回比例尺单位制。。 
    ///	</summary> 
    ///	<returns type="LengthUnit" />

};
BMap.ScaleControl.prototype.setUnit = function (unit)
{
    ///	<summary>
    ///	设置比例尺单位制。 
    ///	</summary> 
    /// <param name="unit" type="LengthUnit">可选参数</param>
};
BMap.GeolocationControl = function (type)
{
    ///	<summary>
    ///	此类是负责进行地图定位的控件，使用html5浏览器定位功能，此类继承Control所有功能。(自 1.4 新增)。 
    ///	</summary> 
    /// <param name="type" type="GeolocationControlOptions">可选参数</param>
};
BMap.GeolocationControl.prototype.location = function ()
{
    ///	<summary>
    ///	开始进行定位 
    ///	</summary> 
};

BMap.GeolocationControl.prototype.getAddressComponent = function ()
{
    ///	<summary>
    ///	返回当前的定位信息。若当前还未定位，则返回null。 
    ///	</summary> 
    ///	<returns type="AddressComponent" />
};

//该控件从Control控制中继承而来,故将Ctrol的方法重复一遍
BMap.GeolocationControl.prototype.defaultAnchor = {}; //	enum ControlAnchor	控件默认的停靠位置。自定义控件时需要提供此属性，作为控件的默认停靠位置。
BMap.GeolocationControl.prototype.defaultOffset = {}; //	Size	控件默认的位置偏移值。自定义控件时需要提供此属性，作为控件的默认偏移位置。
BMap.GeolocationControl.prototype.initialize = function (map)
{
    ///	<summary>
    ///	抽象方法。调用Map.addControl()方法添加控件时将调用此方法，从而实现该控件的初始化。自定义控件时需要实现此方法，并将元素的DOM元素在该方法中返回。DOM元素需要添加到地图的容器中，使用map.getContainer()方法可获得地图容器元素。  
    ///	</summary> 
    /// <param name="map" type="BMap.Map"></param>
    ///	<returns type="HTMLElement" />
};
BMap.GeolocationControl.prototype.setAnchor = function (anchor)
{
    ///	<summary>
    ///	设置控件停靠的位置  
    ///	</summary> 
    /// <param name="anchor" type="ControlAnchor">停靠位置,如:BMAP_ANCHOR_TOP_LEFT</param>
};
BMap.GeolocationControl.prototype.getAnchor = function ()
{
    ///	<summary>
    ///	返回控件停靠的位置,如:BMAP_ANCHOR_TOP_LEFT  
    ///	</summary> 
    ///	<returns type="ControlAnchor" />
};
BMap.GeolocationControl.prototype.setOffset = function (offset)
{
    ///	<summary>
    ///	 设置控件停靠的偏移量 
    ///	</summary> 
    /// <param name="offset" type="BMap.Size"></param>
};
BMap.GeolocationControl.prototype.getOffset = function ()
{
    ///	<summary>
    ///	 返回控件停靠的偏移量:BMap.Size
    ///	</summary> 
    ///	<returns type="BMap.Size" />
};
BMap.GeolocationControl.prototype.show = function ()
{
    ///	<summary>
    ///	 显示控件
    ///	</summary>
};
BMap.GeolocationControl.prototype.hide = function ()
{
    ///	<summary>
    ///	 隐藏控件
    ///	</summary>
};
BMap.GeolocationControl.prototype.isVisible = function ()
{
    ///	<summary>
    ///	判断控件的可见性
    ///	</summary> 
    ///	<returns type="Boolean" />
};
BMap.GeolocationControl.prototype.toString = function ()
{
    ///	<summary>
    ///	 返回描述类型字符串。如果需要，自定义控件需要自行实现此方法以获得描述自身类型的字符串。 
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.GeolocationControl.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	 添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
BMap.GeolocationControl.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	 移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
//*/
var BMapGeolocationEventName =
{
    locationSuccess: "locationSuccess", //{point, AddressComponent}定位成功后触发此事件。
    locationError: "locationError", //{StatusCode}	定位失败后触发此事件。
    //该控件继承了Ctrol全部控件,所以,把Ctrol的也继承下来
    viewchanged: "viewchanged", //	event{type, target, isOpen}	缩略地图开合状态发生变化后触发此事件。
    viewchanging: "viewchanging"//	event{type, target}	缩略地图开合状态发生变化过程中触发此事件。
};
BMap.PanoramaControl = function ()
{
    ///	<summary>
    ///	 此类是负责切换至全景地图的控件，此类继承Control所有功能。（自2.0新增）
    ///	</summary> 
};

BMap.Polyline = function (points, opts)
{
    ///	<summary>
    ///	使用浏览器的矢量制图工具（如果可用）在地图上绘制折线的地图叠加层。  
    ///	</summary> 
    /// <param name="points" type="Array<Point>">点数组,如[new BMap.Point(116.399, 39.910), new BMap.Point(116.405, 39.920)]</param>
    /// <param name="opts" type="PolylineOptions">线的选项</param>
};
BMap.Polyline.prototype.setPath = function (path)
{
    ///	<summary>
    ///	 设置折线的点数组（自1.2新增） 
    ///	</summary> 
    /// <param name="path" type="Array<Point>">需要设置的点数组</param>
};
BMap.Polyline.prototype.getPath = function ()
{
    ///	<summary>
    ///	  返回折线的点数组（自1.2新增）
    ///	</summary> 
    ///	<returns type="Array<Point>	" />
};
BMap.Polyline.prototype.setStrokeColor = function (color)
{
    ///	<summary>
    ///	 设置折线的颜色 
    ///	</summary> 
    /// <param name="color" type="String"></param>
};
BMap.Polyline.prototype.getStrokeColor = function ()
{
    ///	<summary>
    ///	 返回折线的颜色。 
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Polyline.prototype.setStrokeOpacity = function (opacity)
{
    ///	<summary>
    ///	 设置透明度，取值范围0 - 1。 
    ///	</summary> 
    /// <param name="opacity" type="Number">透明度</param>
};
BMap.Polyline.prototype.getStrokeOpacity = function ()
{
    ///	<summary>
    ///	  返回透明度
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Polyline.prototype.setStrokeWeight = function (weight)
{
    ///	<summary>
    ///	设置线的宽度，范围为大于等于1的整数。  
    ///	</summary> 
    /// <param name="weight" type="Number"></param>
};
BMap.Polyline.prototype.BMap.Polyline.prototype.getStrokeWeight = function ()
{
    ///	<summary>
    ///	  返回线的宽度。
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Polyline.prototype.setStrokeStyle = function (style)
{
    ///	<summary>
    ///	设置是为实线或虚线，solid或dashed。  
    ///	</summary> 
    /// <param name="style" type="String">线的名称</param>
};
BMap.Polyline.prototype.getStrokeStyle = function ()
{
    ///	<summary>
    ///	返回当前线样式状态，实线或者虚线。  
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Polyline.prototype.getBounds = function ()
{
    ///	<summary>
    ///	返回覆盖物的地理区域范围。(自 1.1 新增)  
    ///	</summary> 
    ///	<returns type="BMap.Bounds" />
};
BMap.Polyline.prototype.enableEditing = function ()
{
    ///	<summary>
    ///	  开启编辑功能。(自 1.1 新增)
    ///	</summary> 
};
BMap.Polyline.prototype.disableEditing = function ()
{
    ///	<summary>
    ///	  关闭编辑功能。(自 1.1 新增)
    ///	</summary> 
};
BMap.Polyline.prototype.enableMassClear = function ()
{
    ///	<summary>
    ///	  允许覆盖物在map.clearOverlays方法中被清除。(自 1.1 新增)
    ///	</summary> 
};
BMap.Polyline.prototype.disableMassClear = function ()
{
    ///	<summary>
    ///	  禁止覆盖物在map.clearOverlays方法中被清除。(自 1.1 新增)
    ///	</summary> 
};
BMap.Polyline.prototype.setPositionAt = function (index, point)
{
    ///	<summary>
    ///	  修改指定位置的坐标。索引index从0开始计数。例如setPointAt(2, point)代表将折线的第3个点的坐标设为point(自 1.2 新增)
    ///	</summary> 
    /// <param name="index" type="Number">点的索引</param>
    /// <param name="point" type="Point">新的位置</param>
};
BMap.Polyline.prototype.getMap = function ()
{
    ///	<summary>
    ///	返回覆盖物所在的map对象。（自1.2新增)  
    ///	</summary> 
    ///	<returns type="BMap.Map" />

};
BMap.Polyline.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
BMap.Polyline.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	 移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
var BMapPolylineEventName =
{
    click: "click", //	event{type, target, point, pixel}	点击折线后会触发此事件。
    dblclick: "dblclick", //	event{type, target, point, pixel}	双击折线后会触发此事件。
    mousedown: "mousedown", //	event{type, target, point, pixel}	鼠标在折线上按下触发此事件。
    mouseup: "mouseup", //	event{type, target, point, pixel}	鼠标在折线释放触发此事件。
    mouseout: "mouseout", //	event{type, target, point, pixel}	鼠标离开折线时触发此事件。
    mouseover: "mouseover", //	event{type, target, point, pixel}	当鼠标进入折线区域时会触发此事件。
    remove: "remove", //	event{type, target}	移除折线时触发。
    lineupdate: "lineupdate"//	event{type, target}	覆盖物的属性发生变化时触发。(自 1.1 新增)
};
//基类的方法
BMap.Polyline.prototype.show = function ()
{
    ///	<summary>
    ///	显示覆盖物。对于自定义覆盖物，此方法会自动将initialize方法返回的HTML元素样式的display属性设置为空。(自 1.1 更新) 
    ///	</summary> 
};

BMap.Polyline.prototype.hide = function ()
{
    ///	<summary>
    ///	  隐藏覆盖物。对于自定义覆盖物，此方法会自动将initialize方法返回的HTML元素样式的display属性设置为none。
    ///	</summary> 
};
BMap.Marker = function (point, opts)
{
    ///	<summary>
    ///	此类表示地图上一个图像标注。
    ///	</summary> 
    /// <param name="point" type="BMap.Point">标注位置</param>
    /// <param name="opts" type="MarkerOptions">可选参数</param>
};
BMap.Marker.prototype.openInfoWindow = function (infoWnd)
{
    ///	<summary>
    ///	打开信息窗。
    ///	</summary> 
    /// <param name="infoWnd" type="BMap.InfoWindow">需要打开的信息窗口</param>
};
BMap.Marker.prototype.closeInfoWindow = function ()
{
    ///	<summary>
    ///	关闭信息窗。
    ///	</summary> 
};
BMap.Marker.prototype.setIcon = function (icon)
{
    ///	<summary>
    ///	设置标注所用的图标对象。
    ///	</summary> 
    /// <param name="icon" type="BMap.Icon">需要设置的图像</param>
};
BMap.Marker.prototype.getIcon = function ()
{
    ///	<summary>
    ///	返回标注所用的图标对象。
    ///	</summary> 
    ///	<returns type="BMap.Icon" />
};
BMap.Marker.prototype.setPosition = function (position)
{
    ///	<summary>
    ///	设置标注的地理坐标。(自 1.2 新增)
    ///	</summary> 
    /// <param name="position" type="BMap.Point">地理坐标</param>
};
BMap.Marker.prototype.getPosition = function ()
{
    ///	<summary>
    ///	返回标注的地理坐标。(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};
BMap.Marker.prototype.setOffset = function (offset)
{
    ///	<summary>
    ///	设置标注的偏移值。
    ///	</summary> 
    /// <param name="offset" type="BMap.Size">偏移值</param>
};
BMap.Marker.prototype.getOffset = function ()
{
    ///	<summary>
    ///	返回标注的偏移值。
    ///	</summary> 
    ///	<returns type="BMap.Size" />
};
BMap.Marker.prototype.getLabel = function ()
{
    ///	<summary>
    ///	返回标注的文本标注。
    ///	</summary> 
    ///	<returns type="BMap.Label" />
};
BMap.Marker.prototype.setLabel = function (label)
{
    ///	<summary>
    ///	为标注添加文本标注。
    ///	</summary> 
    /// <param name="label" type="BMap.Label"></param>
};
BMap.Marker.prototype.setTitle = function (title)
{
    ///	<summary>
    ///	设置标注的标题，当鼠标移至标注上时显示此标题。
    ///	</summary> 
    /// <param name="title" type="String">标题</param>
};
BMap.Marker.prototype.getTitle = function ()
{
    ///	<summary>
    ///	返回标注的标题。
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Marker.prototype.setTop = function (isTop)
{
    ///	<summary>
    ///	将标注置于其他标注之上。默认情况下，纬度较低的标注会覆盖在纬度较高的标注之上，从而形成一种立体效果。通过此方法可使某个标注覆盖在其他所有标注之上。注意：如果在多个标注对象上调用此方法，则这些标注依旧按照纬度产生默认的覆盖效果。
    ///	</summary> 
    /// <param name="isTop" type="Boolean">是否设置</param>
};
BMap.Marker.prototype.enableDragging = function ()
{
    ///	<summary>
    ///	开启标注拖拽功能。(自 1.1 新增)
    ///	</summary> 
};
BMap.Marker.prototype.disableDragging = function ()
{
    ///	<summary>
    ///	关闭标注拖拽功能。(自 1.1 新增)
    ///	</summary> 
};
BMap.Marker.prototype.enableMassClear = function ()
{
    ///	<summary>
    ///	允许覆盖物在map.clearOverlays方法中被清除。(自 1.1 新增)
    ///	</summary> 
};
BMap.Marker.prototype.disableMassClear = function ()
{
    ///	<summary>
    ///	禁止覆盖物在map.clearOverlays方法中被清除。(自 1.1 新增)
    ///	</summary> 
};
BMap.Marker.prototype.setZIndex = function (zIndex)
{
    ///	<summary>
    ///	设置覆盖物的zIndex。(自 1.1 新增)
    ///	</summary> 
    /// <param name="zIndex" type="Number">新的索引</param>
};
BMap.Marker.prototype.getMap = function ()
{
    ///	<summary>
    ///	返回覆盖物所在的map对象。(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="BMap.Map" />
};
BMap.Marker.prototype.addContextMenu = function (menu)
{
    ///	<summary>
    ///	添加右键菜单。(自 1.2 新增)
    ///	</summary> 
    /// <param name="menu" type="BMap.ContextMenu">需要添加的右键菜单</param>
};
BMap.Marker.prototype.removeContextMenu = function (menu)
{
    ///	<summary>
    ///	移除右键菜单。(自 1.2 新增)
    ///	</summary> 
    /// <param name="menu" type="BMap.ContextMenu">需要移除的菜单</param>

};
BMap.Marker.prototype.setAnimation = function (animation)
{
    ///	<summary>
    ///	设置标注动画效果。如果参数为null，则取消动画效果。该方法需要在addOverlay方法后设置。(自 1.2 新增)
    ///	</summary> 
    /// <param name="animation" type="BMap.Animation"></param>
};
BMap.Marker.prototype.setShadow = function (shadow)
{
    ///	<summary>
    ///	设置标注阴影图标。(自 1.2 新增)
    ///	</summary> 
    /// <param name="shadow" type="BMap.Icon">阴影图标</param>
};
BMap.Marker.prototype.getShadow = function ()
{
    ///	<summary>
    ///	获取标注阴影图标。(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="BMap.Icon" />
};
BMap.Marker.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
BMap.Marker.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
var BMapMarkerEventName =
{
    click: "click", //	event{type, target}	点击标注图标后会触发此事件。
    dblclick: "dblclick", //	event{type, target, point,pixel}	双击标注图标后会触发此事件。
    mousedown: "mousedown", //	event{type, target, point,pixel}	鼠标在标注图上按下触发此事件。
    mouseup: "mouseup", //event{type, target, point,pixel}	鼠标在标注图上释放触发此事件。
    mouseout: "mouseout", //	event{type, target, point,pixel}	鼠标离开标注时触发此事件。
    mouseover: "mouseover", //	event{type, target, point,pixel}	当鼠标进入标注图标区域时会触发此事件。
    remove: "remove", //event{type, target}	移除标注时触发。
    infowindowclose: "infowindowclose", //event{type, target}	信息窗在此标注上关闭时触发此事件。
    infowindowopen: "infowindowopen", //event{type, target}	信息窗在此标注上打开时触发此事件。
    dragstart: "dragstart", //event{type, target}	开始拖拽标注时触发此事件。(自 1.1 新增)
    dragging: "dragging", //event{type, target, pixel, point}	拖拽标注过程中触发此事件。(自 1.1 新增)
    dragend: "dragend", //event{type, target, pixel, point}	拖拽结束时触发此事件。(自 1.1 新增)
    rightclick: "rightclick"//event{type, target}	右键点击标注时触发此事件。(自 1.1 新增)
};
BMap.InfoWindow = function (content, opts)
{
    ///	<summary>
    ///	此类表示地图上包含信息的窗口。其中content支持HTML内容。1.2版本开始content参数支持传入DOM结点。
    ///	</summary> 
    /// <param name="content" type="String">content支持HTML内容</param>
    /// <param name="opts" type="InfoWindowOptions">,可选参数</param>
};
BMap.InfoWindow.prototype.setWidth = function (width)
{
    ///	<summary>
    ///	设置信息窗口的宽度，单位像素。取值范围：220 - 730。
    ///	</summary> 
    /// <param name="width" type="Number">窗口的宽度，单位像素。取值范围：220 - 730</param>
};
BMap.InfoWindow.prototype.setHeight = function (height)
{
    ///	<summary>
    ///	设置信息窗口的高度，单位像素。取值范围：60 - 650。
    ///	</summary> 
    /// <param name="height" type="Number">信息窗口的高度，单位像素。取值范围：60 - 650</param>
};
BMap.InfoWindow.prototype.redraw = function ()
{
    ///	<summary>
    ///	重绘信息窗口，当信息窗口内容发生变化时进行调用。
    ///	</summary> 
};
BMap.InfoWindow.prototype.setTitle = function (title)
{
    ///	<summary>
    ///	设置信息窗口标题。支持HTML内容。1.2版本开始title参数支持传入DOM结点。
    ///	</summary> 
    /// <param name="title" type="String">信息窗口标题。支持HTML内容。1.2版本开始title参数支持传入DOM结点。</param>
};
BMap.InfoWindow.prototype.getTitle = function ()
{
    ///	<summary>
    ///	返回信息窗口标题。(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.InfoWindow.prototype.setContent = function (content)
{
    ///	<summary>
    ///	设置信息窗口内容。支持HTML内容。1.2版本开始content参数支持传入DOM结点。
    ///	</summary> 
    /// <param name="content" type="String">信息窗口内容。支持HTML内容。1.2版本开始content参数支持传入DOM结点。</param>
};
BMap.InfoWindow.prototype.getContent = function ()
{
    ///	<summary>
    ///	返回信息窗口内容。(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.InfoWindow.prototype.getPosition = function ()
{
    ///	<summary>
    ///	返回信息窗口的位置。
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};
BMap.InfoWindow.prototype.enableMaximize = function ()
{
    ///	<summary>
    ///	启用窗口最大化功能。需要设置最大化后信息窗口里的内容，该接口才生效。
    ///	</summary> 
};
BMap.InfoWindow.prototype.disableMaximize = function ()
{
    ///	<summary>
    ///	禁用窗口最大化功能。
    ///	</summary> 
};
BMap.InfoWindow.prototype.isOpen = function ()
{
    ///	<summary>
    ///	返回信息窗口的打开状态。
    ///	</summary> 
    ///	<returns type="Boolean" />
};
BMap.InfoWindow.prototype.setMaxContent = function (content)
{
    ///	<summary>
    ///	信息窗口最大化时所显示内容，支持HTML内容
    ///	</summary> 
    /// <param name="content" type="String">内容，支持HTML内容</param>
};
BMap.InfoWindow.prototype.maximize = function ()
{
    ///	<summary>
    ///	最大化信息窗口(自 1.1 新增)
    ///	</summary> 
};
BMap.InfoWindow.prototype.restore = function ()
{
    ///	<summary>
    ///	还原信息窗口(自 1.1 新增)
    ///	</summary> 
};
BMap.InfoWindow.prototype.enableAutoPan = function ()
{
    ///	<summary>
    ///	开启打开信息窗口时地图自动平移。(自 1.1 新增)
    ///	</summary> 
};
BMap.InfoWindow.prototype.disableAutoPan = function ()
{
    ///	<summary>
    ///	关闭打开信息窗口时地图自动平移。(自 1.1 新增)
    ///	</summary> 
};
BMap.InfoWindow.prototype.enableCloseOnClick = function ()
{
    ///	<summary>
    ///	开启点击地图时关闭信息窗口。(自 1.1 新增)
    ///	</summary> 
};
BMap.InfoWindow.prototype.disableCloseOnClick = function ()
{

    ///	<summary>
    ///	关闭点击地图时关闭信息窗口。(自 1.1 新增)
    ///	</summary> 
};
BMap.InfoWindow.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
BMap.InfoWindow.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
var BMapInfoWindowEventName =
{
    close: "close", //	event{type, target, point}	信息窗口被关闭时触发此事件。
    open: "open", //event{type, target, point}	信息窗口被打开时触发此事件。
    maximize: "maximize", //event{type, target}	信息窗口最大化后触发此事件。(自 1.1 新增)
    restore: "restore", //event{type, target}	信息窗口还原时触发此事件。(自 1.1 新增)
    clickclose: "clickclose"//	event{type, target}	点击信息窗口的关闭按钮时触发此事件。(自 1.1 新增)
};

BMap.Hotspot = function (position, options)
{
    ///	<summary>
    ///	表示地图上的一个热区。(自 1.2 新增)
    ///	</summary> 
    /// <param name="position" type="BMap.Point"></param>
    /// <param name="options" type="HotspotOptions">可选参数</param>
};

BMap.Hotspot.prototype.getPosition = function ()
{
    ///	<summary>
    ///	获取热区位置坐标。(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};
BMap.Hotspot.prototype.setPosition = function (position)
{
    ///	<summary>
    ///	设置热区位置坐标。(自 1.2 新增)
    ///	</summary> 
    /// <param name="position" type="BMap.Point">热区位置坐标</param>
};
BMap.Hotspot.prototype.getText = function ()
{
    ///	<summary>
    ///	获取热区提示文本。(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Hotspot.prototype.setText = function (text)
{
    ///	<summary>
    ///	设置热区提示文本。(自 1.2 新增)
    ///	</summary> 
    /// <param name="text" type="String">热区提示文本</param>
};
BMap.Hotspot.prototype.getUserData = function ()
{
    ///	<summary>
    ///	获取热区对应的用户数据。(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="Mix" />
};
BMap.Hotspot.prototype.setUserData = function (data)
{
    ///	<summary>
    ///	设置热区对应的用户数据。(自 1.2 新增)
    ///	</summary> 
    /// <param name="data" type="Mix"></param>
};
BMap.Polygon = function (points, opts)
{
    ///	<summary>
    ///		创建多边形覆盖物
    ///	</summary> 
    /// <param name="points" type="Array<Point>">记录坐标的数组</param>
    /// <param name="opts" type="PolygonOptions">可选参数</param>
};

BMap.Polygon.prototype.setPath = function (path)
{
    ///	<summary>
    ///	设置多边型的点数组（自1.2新增）
    ///	</summary> 
    /// <param name="path" type="Array<Point>">数组</param>
};
BMap.Polygon.prototype.getPath = function ()
{
    ///	<summary>
    ///	返回多边型的点数组（自1.2新增）
    ///	</summary> 
    ///	<returns type="Array<Point>" />
};
BMap.Polygon.prototype.setStrokeColor = function (color)
{
    ///	<summary>
    ///	设置多边型的边线颜色，参数为合法的CSS颜色值。
    ///	</summary> 
    /// <param name="color" type="String">边线颜色，参数为合法的CSS颜色值</param>
};
BMap.Polygon.prototype.getStrokeColor = function ()
{
    ///	<summary>
    ///	返回多边型的边线颜色。
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Polygon.prototype.setFillColor = function (color)
{
    ///	<summary>
    ///	设置多边形的填充颜色，参数为合法的CSS颜色值。当参数为空字符串时，折线覆盖物将没有填充效果。
    ///	</summary> 
    /// <param name="color" type="String">填充颜色，参数为合法的CSS颜色值</param>
};
BMap.Polygon.prototype.getFillcolor = function ()
{
    ///	<summary>
    ///	返回多边形的填充颜色。
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Polygon.prototype.setStrokeOpacity = function (opacity)
{
    ///	<summary>
    ///	设置多边形的边线透明度，取值范围0 - 1。
    ///	</summary> 
    /// <param name="opacity" type="Number">边线透明度，取值范围0 - 1</param>
};
BMap.Polygon.prototype.getStrokeOpacity = function ()
{
    ///	<summary>
    ///	返回多边形的边线透明度。
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Polygon.prototype.setFillOpacity = function (opacity)
{
    ///	<summary>
    ///	设置多边形的填充透明度，取值范围0 - 1。
    ///	</summary> 
    /// <param name="opacity" type="Number">填充透明度，取值范围0 - 1</param>
};
BMap.Polygon.prototype.getFillOpacity = function ()
{
    ///	<summary>
    ///	返回多边形的填充透明度。
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Polygon.prototype.setStrokeWeight = function (weight)
{
    ///	<summary>
    ///	设置多边形边线的宽度，取值为大于等于1的整数。
    ///	</summary> 
    /// <param name="weight" type="Number">宽度，取值为大于等于1的整数</param>
};
BMap.Polygon.prototype.getStrokeWeight = function ()
{
    ///	<summary>
    ///	返回多边形边线的宽度。
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Polygon.prototype.setStrokeStyle = function (style)
{
    ///	<summary>
    ///	设置多边形边线样式为实线或虚线，取值solid或dashed。
    ///	</summary> 
    /// <param name="style" type="String">实线或虚线，取值solid或dashed</param>
};
BMap.Polygon.prototype.getStrokeStyle = function ()
{
    ///	<summary>
    ///	返回多边形边线样式。
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Polygon.prototype.getBounds = function ()
{
    ///	<summary>
    ///	返回覆盖物的地理区域范围。(自 1.1 新增)
    ///	</summary> 
    ///	<returns type="BMap.Bounds" />
};
BMap.Polygon.prototype.enableEditing = function ()
{
    ///	<summary>
    ///	开启编辑功能(自 1.1 新增)
    ///	</summary> 
};
BMap.Polygon.prototype.disableEditing = function ()
{
    ///	<summary>
    ///	关闭编辑功能(自 1.1 新增)
    ///	</summary> 
};
BMap.Polygon.prototype.enableMassClear = function ()
{
    ///	<summary>
    ///	允许覆盖物在map.clearOverlays方法中被清除(自 1.1 新增)
    ///	</summary> 
};
BMap.Polygon.prototype.disableMassClear = function ()
{
    ///	<summary>
    ///	禁止覆盖物在map.clearOverlays方法中被清除(自 1.1 新增)
    ///	</summary> 
};
BMap.Polygon.prototype.setPositionAt = function (index, point)
{
    ///	<summary>
    ///	修改指定位置的坐标。索引index从0开始计数。例如setPointAt(2, point)代表将折线的第3个点的坐标设为point(自 1.2 新增)
    ///	</summary> 
    /// <param name="index" type="Number">修改点的索引</param>
    /// <param name="point" type="Point">新的坐标位置</param>
};
BMap.Polygon.prototype.getMap = function ()
{
    ///	<summary>
    ///	返回覆盖物所在的map对象。（自1.2新增)
    ///	</summary> 
    ///	<returns type="BMap.Map" />
};
BMap.Polygon.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
BMap.Polygon.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数</param>
};
var BMapPolygonEventName =
{
    click: "click", //	event{type, target, point, pixel}	点击多边形后会触发此事件。
    dblclick: "dblclick", //	event{type, target, point, pixel}	双击多边形后会触发此事件。
    mousedown: "mousedown", //	event{type, target, point, pixel}	鼠标在多边形上按下触发此事件。
    mouseup: "mouseup", //event{type, target, point, pixel}	鼠标在多边形释放触发此事件。
    mouseout: "mouseout", //	event{type, target, point, pixel}	鼠标离开多边形时触发此事件。
    mouseover: "mouseover", //	event{type, target, point, pixel}	当鼠标进入多边形区域时会触发此事件。
    remove: "remove", //event{type, target}	移除多边形时触发。
    lineupdate: "lineupdate"//	event{type, target}	覆盖物的属性发生变化时触发。(自 1.1 新增)
};
BMap.Label = function (content, opts)
{
    ///	<summary>
    ///	;创建一个文本标注实例
    ///	</summary> 
    /// <param name="content" type="String">标注内容</param>
    /// <param name="opts" type="LabelOptions">可选参数选项</param>
};

BMap.Label.prototype.setStyle = function (styles)
{
    ///	<summary>
    ///	设置文本标注样式，该样式将作用于文本标注的容器元素上。其中styles为JavaScript对象常量，比如：
    /// setStyle({ color : "red", fontSize : "12px" }) 注意：如果css的属性名中包含连字符，需要将连字符去掉并将其后的字母进行大写处理，例如：背景色属性要写成：backgroundColor。
    ///	</summary> 
    /// <param name="styles" type="Object">样式表</param>
};
BMap.Label.prototype.setContent = function (content)
{
    ///	<summary>
    ///	设置文本标注的内容。支持HTML。
    ///	</summary> 
    /// <param name="content" type="String">文本标注的内容。支持HTML。</param>
};
BMap.Label.prototype.setPosition = function (position)
{
    ///	<summary>
    ///	设置文本标注坐标。仅当通过Map.addOverlay()方法添加的文本标注有效。(自 1.2 新增)
    ///	</summary> 
    /// <param name="position" type="BMap.Point">文本标注坐标</param>
};
BMap.Label.prototype.getPosition = function ()
{
    ///	<summary>
    ///	获取Label的地理坐标.(自 1.2 新增)
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};
BMap.Label.prototype.setOffset = function (offset)
{
    ///	<summary>
    ///	设置文本标注的偏移值。
    ///	</summary> 
    /// <param name="offset" type="BMap.Size">文本标注的偏移值</param>
};
BMap.Label.prototype.getOffset = function ()
{
    ///	<summary>
    ///	返回文本标注的偏移值
    ///	</summary> 
    ///	<returns type="BMap.Size" />
};
BMap.Label.prototype.setTitle = function (title)
{
    ///	<summary>
    ///	设置文本标注的标题，当鼠标移至标注上时显示此标题。
    ///	</summary> 
    /// <param name="title" type="String">文本标注的标题</param>
};
BMap.Label.prototype.getTitle = function ()
{
    ///	<summary>
    ///	返回文本标注的标题。
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Label.prototype.enableMassClear = function ()
{
    ///	<summary>
    ///	允许覆盖物在map.clearOverlays方法中被清除。(自 1.1 新增)
    ///	</summary> 
};
BMap.Label.prototype.disableMassClear = function ()
{
    ///	<summary>
    ///	禁止覆盖物在map.clearOverlays方法中被清除。(自 1.1 新增)
    ///	</summary> 
};
BMap.Label.prototype.setZIndex = function (zIndex)
{
    ///	<summary>
    ///	设置覆盖物的zIndex。(自 1.1 新增)
    ///	</summary> 
    /// <param name="zIndex" type="Number">覆盖物的zIndex</param>
}; none
BMap.Label.prototype.setPosition = function (position)
{
    ///	<summary>
    ///	设置地理坐标（自1.2新增）
    ///	</summary> 
    /// <param name="position" type="BMap.Point">地理坐标</param>
};
BMap.Label.prototype.getMap = function ()
{
    ///	<summary>
    ///	返回覆盖物所在的map对象。（自1.2新增)
    ///	</summary> 
    ///	<returns type="BMap.Map" />
};
BMap.Label.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数
};
BMap.Label.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数
};
var BMapLabelEventName =
{
    click: "click", //	event{type, target}	点击文本标注后会触发此事件。
    dblclick: "dblclick", //	event{type, target}	双击文本标注后会触发此事件。
    mousedown: "mousedown", //	event{type, target}	鼠标在文本标注上按下触发此事件。
    mouseup: "mouseup", //	event{type, target}	鼠标在文本标注释放触发此事件。
    mouseout: "mouseout", //	event{type, target}	鼠标离开文本标注时触发此事件。
    mouseover: "mouseover", //	event{type, target}	当鼠标进入文本标注区域时会触发此事件。
    remove: "remove", //	event{type, target}	移除文本标注时触发。
    rightclick: "rightclick"//	event{type, target}	右键点击标注时触发此事件。(自 1.1 新增)
};
BMap.Icon = function (url, opts)
{
    ///	<summary>
    ///	此类表示标注覆盖物所使用的图标。以给定的图像地址和大小创建图标对象实例。
    ///	</summary> 
    /// <param name="url" type="String">图片地址</param>
    /// <param name="opts" type="IconOptions">可选参数,选项</param>
};

BMap.Icon.prototype.anchor = {}; //	Size图标的定位点相对于图标左上角的偏移值。(自1.2 新增)
BMap.Icon.prototype.size = {}; //Size	图标可视区域的大小。
BMap.Icon.prototype.imageOffset = {}; //Size	图标所用的图片相对于可视区域的偏移值，此功能的作用等同于CSS中的background-position属性。
BMap.Icon.prototype.imageSize = {}; //Size	图标所用的图片的大小，此功能的作用等同于CSS中的background-size属性。可用于实现高清屏的高清效果。(自1.4 新增)
BMap.Icon.prototype.imageUrl = {}; //String	图标所用图像资源的位置。
BMap.Icon.prototype.infoWindowOffset = {}; //	Size	信息窗口开启位置相对于图标左上角的偏移值。(自1.2 废弃)
BMap.Icon.prototype.infoWindowAnchor = {}; //	Size	信息窗口开启位置相对于图标左上角的偏移值。(自1.2 新增)
BMap.Icon.prototype.printImageUrl = {}; //String	设置icon打印图片的url，该打印图片只针对IE6有效，解决IE6使用PNG滤镜导致的错位问题。如果您的icon没有使用PNG格式图片或者没有使用CSS Sprites技术，则可忽略此配置。(自1.1 新增)
BMap.Icon.prototype.setImageUrl = function (imageUrl)
{
    ///	<summary>
    ///	设置图片资源的地址。
    ///	</summary> 
    /// <param name="imageUrl" type="String">图片资源的地址</param>
};
BMap.Icon.prototype.setSize = function (size)
{
    ///	<summary>
    ///	设置图标可视区域的大小。
    ///	</summary> 
    /// <param name="size" type="BMap.Size">可视区域的大小</param>
};
BMap.Icon.prototype.setImageSize = function (offset)
{
    ///	<summary>
    ///	设置图标的大小。(自 1.4 新增)
    ///	</summary> 
    /// <param name="offset" type="BMap.Size">图标的大小</param>
};
BMap.Icon.prototype.setAnchor = function (anchor)
{
    ///	<summary>
    ///	设置图标定位点相对于其左上角的偏移值。(自 1.2 新增)
    ///	</summary> 
    /// <param name="anchor" type="BMap.Size">偏移值</param>
};
BMap.Icon.prototype.setImageOffset = function (offset)
{
    ///	<summary>
    ///	设置图片相对于可视区域的偏移值。
    ///	</summary> 
    /// <param name="offset" type="BMap.Size">偏移值</param>
};
BMap.Icon.prototype.setInfoWindowAnchor = function (anchor)
{
    ///	<summary>
    ///	设置信息窗口开启位置相对于图标左上角的偏移值。(自 1.2 新增)
    ///	</summary> 
    /// <param name="anchor" type="BMap.Size">偏移值</param>
};
BMap.Icon.prototype.setPrintImageUrl = function (url)
{
    ///	<summary>
    ///	设置icon的打印图片，该打印图片只针对IE6有效，解决IE6使用PNG滤镜导致的错位问题。如果您的icon没有使用PNG格式图片或者没有使用CSS Sprites技术，则可忽略此配置。(自 1.1 新增)
    ///	</summary> 
    /// <param name="url" type="String">图片地址</param>
};
BMap.Circle = function (center, radius, opts)
{
    ///	<summary>
    ///	创建圆覆盖物。(自 1.1 新增)
    ///	</summary> 
    /// <param name="center" type="BMap.Point">圆心坐标</param>
    /// <param name="radius" type="Number">半径,单位为米</param>
    /// <param name="opts" type="CircleOptions">可选参数,选项</param>
};

BMap.Circle.prototype.setCenter = function (center)
{
    ///	<summary>
    ///	设置圆形的中心点坐标。
    ///	</summary> 
    /// <param name="center" type="BMap.Point">中心点坐标</param>
};
BMap.Circle.prototype.getCenter = function ()
{
    ///	<summary>
    ///	返回圆形的中心点坐标。
    ///	</summary> 
    ///	<returns type="BMap.Point" />
};
BMap.Circle.prototype.setRadius = function (radius)
{
    ///	<summary>
    ///	设置圆形的半径，单位为米。
    ///	</summary> 
    /// <param name="radius" type="Number">半径，单位为米</param>
};
BMap.Circle.prototype.getRadius = function ()
{
    ///	<summary>
    ///	返回圆形的半径，单位为米。
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Circle.prototype.getBounds = function ()
{
    ///	<summary>
    ///	返回圆形的地理区域范围。
    ///	</summary> 
    ///	<returns type="BMap.Bounds" />
};
BMap.Circle.prototype.setStrokeColor = function (color)
{
    ///	<summary>
    ///	设置圆形的边线颜色，参数为合法的CSS颜色值。
    ///	</summary> 
    /// <param name="color" type="String">边线颜色，参数为合法的CSS颜色值</param>
};
BMap.Circle.prototype.getStrokeColor = function ()
{
    ///	<summary>
    ///	返回圆形的边线颜色。
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Circle.prototype.setFillColor = function (color)
{
    ///	<summary>
    ///	设置圆形的填充颜色，参数为合法的CSS颜色值。当参数为空字符串时，圆形覆盖物将没有填充效果。
    ///	</summary> 
    /// <param name="color" type="String">填充颜色，参数为合法的CSS颜色值。当参数为空字符串时，圆形覆盖物将没有填充效果</param>
};
BMap.Circle.prototype.getFillColor = function ()
{
    ///	<summary>
    ///	返回圆形的填充颜色。
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Circle.prototype.setStrokeOpacity = function (opacity)
{
    ///	<summary>
    ///	设置圆形的边线透明度，取值范围0 - 1。
    ///	</summary> 
    /// <param name="opacity" type="Number">边线透明度，取值范围0 - 1</param>
};
BMap.Circle.prototype.getStrokeOpacity = function ()
{
    ///	<summary>
    ///	返回圆形的边线透明度。
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Circle.prototype.setFillOpacity = function (opacity)
{
    ///	<summary>
    ///设置圆形的透明度，取值范围0 - 1。
    ///	</summary> 
    /// <param name="opacity" type="Number">填充透明度，取值范围0 - 1</param>
};
BMap.Circle.prototype.getFillOpacity = function ()
{
    ///	<summary>
    ///	返回圆形的填充透明度。
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Circle.prototype.setStrokeWeight = function (weight)
{
    ///	<summary>
    ///	设置圆形边线的宽度，取值为大于等于1的整数。
    ///	</summary> 
    /// <param name="weight" type="Number">宽度，取值为大于等于1的整数</param>
};
BMap.Circle.prototype.getStrokeWeight = function ()
{
    ///	<summary>
    ///	返回圆形边线的宽度。
    ///	</summary> 
    ///	<returns type="Number" />
};
BMap.Circle.prototype.setStrokeStyle = function (style)
{
    ///	<summary>
    ///	设置圆形边线样式为实线或虚线，取值solid或dashed。
    ///	</summary> 
    /// <param name="style" type="String">实线或虚线，取值solid或dashed</param>
};
BMap.Circle.prototype.getStrokeStyle = function ()
{
    ///	<summary>
    ///	返回圆形边线样式。
    ///	</summary> 
    ///	<returns type="String" />
};
BMap.Circle.prototype.enableEditing = function ()
{
    ///	<summary>
    ///	开启编辑功能
    ///	</summary> 
};
BMap.Circle.prototype.disableEditing = function ()
{
    ///	<summary>
    ///	关闭编辑功能
    ///	</summary> 
};
BMap.Circle.prototype.enableMassClear = function ()
{
    ///	<summary>
    ///	允许覆盖物在map.clearOverlays方法中被清除
    ///	</summary> 
};
BMap.Circle.prototype.disableMassClear = function ()
{
    ///	<summary>
    ///	禁止覆盖物在map.clearOverlays方法中被清除
    ///	</summary> 
};
BMap.Circle.prototype.getMap = function ()
{
    ///	<summary>
    ///	返回覆盖物所在的map对象。（自1.2新增)
    ///	</summary> 
    ///	<returns type="BMap.Map" />
};
BMap.Circle.prototype.addEventListener = function (event, handler)
{
    ///	<summary>
    ///	添加事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数
};
BMap.Circle.prototype.removeEventListener = function (event, handler)
{
    ///	<summary>
    ///	移除事件监听函数
    ///	</summary> 
    /// <param name="event" type="String">事件名称</param>
    /// <param name="handler" type="Function">回调函数
};
var BMapCircleEventName =
{
    click: "click", //	event{type, target, point, pixel}	鼠标点击圆形后会触发此事件。
    dblclick: "dblclick", //	event{type, target, point, pixel}	鼠标双击圆形后会触发此事件。
    mousedown: "mousedown", //	event{type, target, point, pixel}	鼠标在圆形上按下触发此事件。
    mouseup: "mouseup", //event{type, target, point, pixel}	鼠标在圆形释放触发此事件。
    mouseout: "mouseout", //	event{type, target, point, pixel}	鼠标离开圆形时触发此事件。
    mouseover: "mouseover", //	event{type, target, point, pixel}	当鼠标进入圆形区域时会触发此事件。
    remove: "remove", //	event{type, target}	移除圆形时触发此事件。
    lineupdate: "lineupdate"//event{type, target}	圆形覆盖物的属性发生变化时触发此事件。
};
BMap.MenuItem = function (text, callback, opts)
{
    ///	<summary>
    ///	创建一个菜单项。当菜单项被点击时，系统将会以当前菜单弹出的地理坐标点作为参数调用回调函数callback。
    ///	</summary> 
    /// <param name="text" type="String">菜单文本</param>
    /// <param name="callback" type="Function">单击菜单后的回调函数</param>
    /// <param name="opts" type="MenuItemOptions">可选项,可以直接传入数字作为宽度</param>
};
BMap.MenuItem.prototype.setText = function (text)
{
    ///	<summary>
    ///	设置菜单项显示的文本。
    ///	</summary> 
    /// <param name="text" type="String">菜单项显示的文本</param>
};
BMap.MenuItem.prototype.enable = function ()
{
    ///	<summary>
    ///	启用菜单项。
    ///	</summary> 
};
BMap.MenuItem.prototype.disable = function ()
{
    ///	<summary>
    ///	禁用菜单项。
    ///	</summary> 
};

BMap.ContextMenu = function ()
{
    ///	<summary>
    ///	创建一个右键菜单实例,此类表示右键菜单。您可以在地图上添加自定义内容的右键菜单。
    ///	</summary> 
};
BMap.ContextMenu.prototype.addItem = function (item)
{
    ///	<summary>
    ///	添加菜单项。
    ///	</summary> 
    /// <param name="item" type="BMap.MenuItem">菜单项</param>
};
BMap.ContextMenu.prototype.getItemfunction = function (index)
{
    ///	<summary>
    ///	返回指定索引位置的菜单项，第一个菜单项的索引为0。
    ///	</summary> 
    /// <param name="index" type="Number">菜单项索引</param>
    ///	<returns type="BMap.MenuItem" />
};
BMap.ContextMenu.prototype.removeItemfunction = function (item)
{
    ///	<summary>
    ///	移除菜单项。
    ///	</summary> 
    /// <param name="item" type="BMap.MenuItem">菜单项</param>
};
BMap.ContextMenu.prototype.addSeparatorfunction = function ()
{
    ///	<summary>
    ///	添加分隔符。
    ///	</summary> 
};
BMap.ContextMenu.prototype.removeSeparatorfunction = function (index)
{
    ///	<summary>
    ///	移除指定索引位置的分隔符，第一个分隔符的索引为0。
    ///	</summary> 
    /// <param name="index" type="Number">索引</param>
};		
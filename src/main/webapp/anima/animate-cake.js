/**
 * Created by blazh on 2016/11/25.
 */




(function($){



    //所有动画类型
    $.animateType= {
        "bounce": "bounce",
        "flash": "flash",
        "pulse": "pulse",
        "rubberBand": "rubberBand",
        "shake": "shake",
        "headShake": "headShake",
        "swing": "swing",
        "tada": "tada",
        "wobble": "wobble",
        "jello": "jello",
        "bounceIn": "bounceIn",
        "bounceInDown": "bounceInDown",
        "bounceInLeft": "bounceInLeft",
        "bounceInRight": "bounceInRight",
        "bounceInUp": "bounceInUp",
        "bounceOut": "bounceOut",
        "bounceOutDown": "bounceOutDown",
        "bounceOutLeft": "bounceOutLeft",
        "bounceOutRight": "bounceOutRight",
        "bounceOutUp": "bounceOutUp",
        "fadeIn": "fadeIn",
        "fadeInDown": "fadeInDown",
        "fadeInDownBig": "fadeInDownBig",
        "fadeInLeft": "fadeInLeft",
        "fadeInLeftBig": "fadeInLeftBig",
        "fadeInRight": "fadeInRight",
        "fadeInRightBig": "fadeInRightBig",
        "fadeInUp": "fadeInUp",
        "fadeInUpBig": "fadeInUpBig",
        "fadeOut": "fadeOut",
        "fadeOutDown": "fadeOutDown",
        "fadeOutDownBig": "fadeOutDownBig",
        "fadeOutLeft": "fadeOutLeft",
        "fadeOutLeftBig": "fadeOutLeftBig",
        "fadeOutRight": "fadeOutRight",
        "fadeOutRightBig": "fadeOutRightBig",
        "fadeOutUp": "fadeOutUp",
        "fadeOutUpBig": "fadeOutUpBig",
        "flip": "flip",
        "flipInX": "flipInX",
        "flipInY": "flipInY",
        "flipOutX": "flipOutX",
        "flipOutY": "flipOutY",
        "lightSpeedIn": "lightSpeedIn",
        "lightSpeedOut": "lightSpeedOut",
        "rotateIn": "rotateIn",
        "rotateInDownLeft": "rotateInDownLeft",
        "rotateInDownRight": "rotateInDownRight",
        "rotateInUpLeft": "rotateInUpLeft",
        "rotateInUpRight": "rotateInUpRight",
        "rotateOut": "rotateOut",
        "rotateOutDownLeft": "rotateOutDownLeft",
        "rotateOutDownRight": "rotateOutDownRight",
        "rotateOutUpLeft": "rotateOutUpLeft",
        "rotateOutUpRight": "rotateOutUpRight",
        "hinge": "hinge",
        "rollIn": "rollIn",
        "rollOut": "rollOut",
        "zoomIn": "zoomIn",
        "zoomInDown": "zoomInDown",
        "zoomInLeft": "zoomInLeft",
        "zoomInRight": "zoomInRight",
        "zoomInUp": "zoomInUp",
        "zoomOut": "zoomOut",
        "zoomOutDown": "zoomOutDown",
        "zoomOutLeft": "zoomOutLeft",
        "zoomOutRight": "zoomOutRight",
        "zoomOutUp": "zoomOutUp",
        "slideInDown": "slideInDown",
        "slideInLeft": "slideInLeft",
        "slideInRight": "slideInRight",
        "slideInUp": "slideInUp",
        "slideOutDown": "slideOutDown",
        "slideOutLeft": "slideOutLeft",
        "slideOutRight": "slideOutRight",
        "slideOutUp": "slideOutUp"
    }

    //执行动画
    $.fn.doAnima = function (anima) {
        this.each(function () {
            $(this).css('transition', 'left 0s linear').removeClass($(this).data('anima')).addClass('animated ' + anima).data('anima','animated ' + anima);
        })
    }

    //清除动画
    $.fn.clearAnima = function () {
        this.each(function () {
            $(this).css('transition', 'left 0s linear').removeClass($(this).data('anima'))
        })
    }

})($)
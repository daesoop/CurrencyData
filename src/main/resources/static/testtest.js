$(document).ready(function(){

    // resize 이벤트가 발생할때마다 사이즈를 조절합니다.
    $(window).resize(resizeContents);

    // 처음 페이지가 뜰때 사이즈 조정 부분 입니다.
    resizeContents();

});

// 메뉴와 컨텐츠의 높이를 윈도우 높이에서 헤더 부분을 뺀 크기로 지정합니다.

function resizeContents() {
    $("#menu").height($(window).height()-50);
    $("#contents").height($(window).height()-50);
}


$.ui.plugin.add("resizable", "alsoResizeReverse", {

    start: function(event, ui) {

        var self = $(this).data("resizable"), o = self.options;

        var _store = function(exp) {
            $(exp).each(function() {
                $(this).data("resizable-alsoresize-reverse", {
                    width: parseInt($(this).width(), 10), height: parseInt($(this).height(), 10),
                    left: parseInt($(this).css('left'), 10), top: parseInt($(this).css('top'), 10)
                });
            });
        };

        if (typeof(o.alsoResizeReverse) == 'object' && !o.alsoResizeReverse.parentNode) {
            if (o.alsoResizeReverse.length) { o.alsoResize = o.alsoResizeReverse[0];    _store(o.alsoResizeReverse); }
            else { $.each(o.alsoResizeReverse, function(exp, c) { _store(exp); }); }
        }else{
            _store(o.alsoResizeReverse);
        }
    },

    resize: function(event, ui){
        var self = $(this).data("resizable"), o = self.options, os = self.originalSize, op = self.originalPosition;

        var delta = {
                height: (self.size.height - os.height) || 0, width: (self.size.width - os.width) || 0,
                top: (self.position.top - op.top) || 0, left: (self.position.left - op.left) || 0
            },

            _alsoResizeReverse = function(exp, c) {
                $(exp).each(function() {
                    var el = $(this), start = $(this).data("resizable-alsoresize-reverse"), style = {}, css = c && c.length ? c : ['width', 'height', 'top', 'left'];

                    $.each(css || ['width', 'height', 'top', 'left'], function(i, prop) {
                        var sum = (start[prop]||0) - (delta[prop]||0);
                        if (sum && sum >= 0)
                            style[prop] = sum || null;
                    });

                    //Opera fixing relative position
                    if (/relative/.test(el.css('position')) && $.browser.opera) {
                        self._revertToRelativePosition = true;
                        el.css({ position: 'absolute', top: 'auto', left: 'auto' });
                    }

                    el.css(style);
                });
            };

        if (typeof(o.alsoResizeReverse) == 'object' && !o.alsoResizeReverse.nodeType) {
            $.each(o.alsoResizeReverse, function(exp, c) { _alsoResizeReverse(exp, c); });
        }else{
            _alsoResizeReverse(o.alsoResizeReverse);
        }
    },

    stop: function(event, ui){
        var self = $(this).data("resizable");

        //Opera fixing relative position
        if (self._revertToRelativePosition && $.browser.opera) {
            self._revertToRelativePosition = false;
            el.css({ position: 'relative' });
        }

        $(this).removeData("resizable-alsoresize-reverse");
    }
});

$(function() {

    $("#resizable").resizable({
        alsoResizeReverse: ".myframe"
    });

});
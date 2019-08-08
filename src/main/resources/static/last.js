$.ui.plugin.add("resizable", "alsoResizeReverse", {
    start: function () {
        var that = $(this).data("ui-resizable"),
            o = that.options,
            _store = function (exp) {
                $(exp).each(function() {
                    var el = $(this);
                    el.data("ui-resizable-alsoresize-reverse", {
                        width: parseInt(el.width(), 10), height: parseInt(el.height(), 10),
                        left: parseInt(el.css("left"), 10), top: parseInt(el.css("top"), 10)
                    });
                });
            };
        if (typeof(o.alsoResizeReverse) === "object" && !o.alsoResizeReverse.parentNode) {
            if (o.alsoResizeReverse.length) { o.alsoResizeReverse = o.alsoResizeReverse[0]; _store(o.alsoResizeReverse); }
            else { $.each(o.alsoResizeReverse, function (exp) { _store(exp); }); }
        }else{
            _store(o.alsoResizeReverse);
        }
    },
    resize: function (event, ui) {
        var that = $(this).data("ui-resizable"),
            o = that.options,
            os = that.originalSize,
            op = that.originalPosition,
            delta = {
                height: (that.size.height - os.height) || 0, width: (that.size.width - os.width) || 0,
                top: (that.position.bottom - op.bottom) || 0, left: (that.position.right - op.right) || 0
            },
            _alsoResizeReverse = function (exp, c) {
                $(exp).each(function() {
                    var el = $(this), start = $(this).data("ui-resizable-alsoresize-reverse"), style = {},
                        css = c && c.length ? c : el.parents(ui.originalElement[0]).length ? ["width", "height", "top", "left"] : ["width", "height", "top", "left"];
                    $.each(css, function (i, prop) {
                        var sum = (start[prop]||0) - (delta[prop]||0);
                        if (sum && sum >= 0) {
                            style[prop] = sum || null;
                        }
                    });
                    el.css(style);
                });
            };
        if (typeof(o.alsoResizeReverse) === "object" && !o.alsoResizeReverse.nodeType) {
            $.each(o.alsoResizeReverse, function (exp, c) { _alsoResizeReverse(exp, c); });
        }else{
            _alsoResizeReverse(o.alsoResizeReverse);
        }
    },
    stop: function () {
        $(this).removeData("resizable-alsoresize-reverse");
    }
});

// var fill = document.querySelector('.fill');
// var banner = document.querySelector('.banner');
// var menu = document.querySelector('.menu');
var empties = document.querySelectorAll('.empty');
var junk = document.querySelector('.junk');
var wrapper = document.querySelector('#wrapper');
var header = $('#header');
var left = $('#leftcolumn');
var right = $('#rightcolumn');
var main = $('#content');
var footer = $('#footer');
$('#header').draggable();
$('#leftcolumn').draggable();
$('#rightcolumn').draggable();
$('#content').draggable();
$('#footer').draggable();
$('.html_button').click(making);
function making(e) {
    // alert(form.toHTML());
    e.preventDefault();
    console.log("html making success");
    alert("성공");
    // var element = document.getElementById('wrapper');
    var element = $('#wrapper').html();
    console.log(element);
    alert("체크");
    var url = '/makeFile';
    $.ajax({
        type : 'post',
        url : url,
        data : JSON.stringify(element),
        contentType : 'application/json',
        error : function (xhr) {
            alert('error');
            console.log(xhr);
        },
        success : function (data) {
            alert('success');
            console.log(data);
        }
    })
}

function positionAbsolute() {
    console.log("되나요")
    $('#content').css('position', 'absolute');
    $('#header').css('position', 'absolute');
    $('#leftcolumn').css('position', 'absolute');
    $('#rightcolumn').css('position', 'absolute');
    $('#footer').css('position', 'absolute');
}

function findPlace(e) {
    console.log("content width : " + $('#content').width());
    console.log('content height : ' + $('#content').height());
    console.log('header width : ' + $('#header').width());
    console.log('header height : ' + $('#header').height());
    console.log('left width : ' + $('#leftcolumn').width());
    console.log('left height : ' + $('#leftcolumn').height());
    console.log('right width : ' + $('#rightcolumn').width());
    console.log("right height : " + $('#rightcolumn').height());
    console.log('footer width : ' + $('#footer').width());
    console.log('footer height : ' + $('#footer').height());

}

$(function() {
    $('#wrapper').sortable();
    $('#header').resizable();
    $('#leftcolumn').resizable({
        alsoResizeReverse: '#content',
    });
    $('#rightcolumn').resizable({
        alsoResizeReverse: '#content',
    });
    $('#content').resizable({
        alsoResize: '#header',
    });
    $('#footer').resizable({
        alsoResize: '#content',
    });
    $('#header').draggable('disable');
    $('#leftcolumn').draggable('disable');
    $('#rightcolumn').draggable('disable');
    $('#content').draggable('disable');
    $('#footer').draggable('disable');
    $('.fill').draggable({
        stop : function() {
            $(this).css('left', 0);
            $(this).css('top', 0);
            console.log("필 드래그 스탑");
        },
        drag: function(event,ui){
            dragposition = ui.position;
        },
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('menu', 'fill');
            console.log('fill start function working')
        }
    })
    $('.menu').draggable({
        stop : function() {
            $(this).css('left', 0);
            $(this).css('top', 0);
            console.log("메뉴 드래그 스탑");
        },
        drag: function(event,ui){
            dragposition = ui.position;
        },
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('menu', 'menu');
            console.log('start function working')
        }
    })
    $('.banner').draggable({
        stop : function() {
            $(this).css('margin', 0);
            $(this).css('left', 0);
            $(this).css('top', 0);
            console.log("배너 드래그 스탑");
        },
        drag: function(event,ui){
            dragposition = ui.position;
        },
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('menu', 'banner');
            console.log('start function working')
        }
    })
});

$('#header').droppable({
    drop: function(event, ui) {
        ui.draggable.draggable( "option", "revert", false);
        var menu = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        if (menu == 'fill') {
            $(this).append(fill);
            findPlace();
        } else if (menu == 'menu') {
            $(this).append(menuSelect);
            findPlace();
        } else if (menu == 'banner') {
            $(this).append(banner);
            findPlace();
        }
        console.log("header 드롭~ ");
    }
});
$('#content').droppable({
    drop: function(event, ui) {
        ui.draggable.draggable( "option", "revert", false);
        var menu = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        if (menu == 'fill') {
            $(this).append(fill);
            findPlace();
        } else if (menu == 'menu') {
            $(this).append(menuSelect);
            findPlace();
        } else if (menu == 'banner') {
            $(this).append(banner);
            findPlace();
        }
        console.log("main 드롭~ ");
    }
});
$('#leftcolumn').droppable({
    drop: function(event, ui) {
        ui.draggable.draggable( "option", "revert", false);
        var menu = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        if (menu == 'fill') {
            $(this).append(fill);
            findPlace();
        } else if (menu == 'menu') {
            $(this).append(menuSelect);
            findPlace();
        } else if (menu == 'banner') {
            $(this).append(banner);
            findPlace();
        }
        console.log("left 드롭~ ");
    }
});

$('#rightcolumn').droppable({
    drop: function(event, ui) {
        ui.draggable.draggable( "option", "revert", false);
        var menu = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        if (menu == 'fill') {
            $(this).append(fill);
            findPlace();
        } else if (menu == 'menu') {
            $(this).append(menuSelect);
            findPlace();
        } else if (menu == 'banner') {
            $(this).append(banner);
            findPlace();
        }
        console.log("right 드롭~ ");
    }
});
$('#footer').droppable({
    drop: function(event, ui) {
        ui.draggable.draggable( "option", "revert", false);
        var menu = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        if (menu == 'fill') {
            $(this).append(fill);
            findPlace();
        } else if (menu == 'menu') {
            $(this).append(menuSelect);
            findPlace();
        } else if (menu == 'banner') {
            $(this).append(banner);
            findPlace();
        }
        console.log("footer 드롭~ ");
    }
});
$('#wrapper').droppable({
    drop: function(event, ui) {
        ui.draggable.draggable( "option", "revert", false);
        var wrapper = localStorage.getItem('wrapper');
        var header = document.querySelector('#header');
        var main = document.querySelector('#content');
        var left = document.querySelector('#leftcolumn');
        var right = document.querySelector('#rightcolumn');
        var footer = document.querySelector('#footer');
        if (wrapper == 'header') {
            $(this).append(header);
        } else if (wrapper == 'main') {
            $(this).append(main);
        } else if (wrapper == 'left') {
            $(this).append(left);
        } else if (wrapper == 'right') {
            $(this).append(right);
        } else if (wrapper == 'footer') {
            $(this).append(footer);
        }
        console.log("wrapper rop success 드롭");
    }
});

$("#garbage").droppable({
    drop: function( event, ui ) {
        ui.draggable.draggable( "option", "revert", false);
        var junk = localStorage.getItem('junk');
        var header = document.querySelector('#header');
        var main = document.querySelector('#content');
        var left = document.querySelector('#leftcolumn');
        var right = document.querySelector('#rightcolumn');
        var footer = document.querySelector('#footer');
        if (junk == 'header') {
            $(this).append(header);
        } else if (junk == 'main') {
            $(this).append(main);
        } else if (junk == 'left') {
            $(this).append(left);
        } else if (junk == 'right') {
            $(this).append(right);
        } else if (junk == 'footer') {
            $(this).append(footer);
        }
        console.log("drop drop drop");
    }
})
//바탕화면들
// Loop through empties and call drag events
// 대기실
for (var empty of empties) {
    empty.addEventListener('dragover', dragOver);
    empty.addEventListener('dragenter', dragEnter);
    empty.addEventListener('dragleave', dragLeave);
    empty.addEventListener('drop', dragDrop);
    // empty.addEventListener('drop', fillDragDrop);
    // empty.addEventListener('drop', bannerDragDrop);
}
junk.addEventListener('dragover', dragOver);
junk.addEventListener('dragenter', dragEnter);
junk.addEventListener('dragleave', dragLeave);
junk.addEventListener('drop', dragJunk);

//html 화면 단
wrapper.addEventListener('dragover', dragOver);
wrapper.addEventListener('dragenter', dragEnter);
wrapper.addEventListener('dragleave', dragLeave);
wrapper.addEventListener('drop', dragWrapper);

function headerDragStart() {
    console.log('header drag start!|')
    // setTimeout(() => (this.className = 'invisible'), 0);
    localStorage.setItem('junk', 'header');
    localStorage.setItem('wrapper', 'header');
    console.log('header drag start this.classname : ' + this.className)
}

function leftDragStart() {
    console.log('left drag start!|')
    // setTimeout(() => (this.className = 'invisible'), 0);
    localStorage.setItem('junk', 'left');
    localStorage.setItem('wrapper', 'left');
    console.log('left drag start this.classname  : ' + this.className)
}

function rightDragStart() {
    console.log('right drag start!|')
    // setTimeout(() => (this.className = 'invisible'), 0);
    localStorage.setItem('junk', 'right');
    localStorage.setItem('wrapper', 'right');
    console.log('right drag start this.classname : ' + this.className)
}

function mainDragStart() {
    console.log('main drag start!|');
    // setTimeout(() => (this.className = 'invisible'), 0);
    localStorage.setItem('junk', 'main');
    console.log('main drag start this.classname : ' + this.className)
}

function footerDragStart() {
    console.log('footer drag start!|');
    // setTimeout(() => (this.className = 'invisible'), 0);
    localStorage.setItem('junk', 'footer');
    localStorage.setItem('wrapper', 'footer');
    console.log('footer drag start this.classname : ' + this.className)
}

function headerDragEnd() {
    this.className = 'header';
}

function leftDragEnd() {
    this.className = 'left';
}

function rightDragEnd() {
    this.className = 'right';
}

function footerDragEnd() {
    this.className = 'footer';
}

function mainDragEnd() {
    this.className = 'main';
}

function fillDragStart() {
    console.log('start');
    setTimeout(() => (this.className = 'invisible'), 0);
    console.log('fill drag start invisible : ' + this.className);
    this.className = 'fill';
    localStorage.setItem("file", "fill")
    console.log('fill drag start this.className : ' + this.className);
}

function bannerDragStart() {
    setTimeout(() => (this.className = 'invisible'), 0);
    console.log('banner start invisible : ' + this.className);
    this.className = 'banner';
    localStorage.setItem("file", 'banner');
    console.log('banner start this.className : ' + this.className);
}

function menuDragStart() {
    setTimeout(() => (this.className = 'invisible'), 0);
    console.log('menu start invisible : ' + this.className);
    this.className = 'menu';
    localStorage.setItem("file", 'menu');
    console.log('menu start this.className : ' + this.className);
}

// Drag Functions
function dragStart() {
    // this.className += ' hold';
    setTimeout(() => (this.className = 'invisible'), 0);
}

function dragOver(e) {
    e.preventDefault();
    // console.log("over this.className : " + this.className)
    // console.log('over e.target.classname : ' +this.className)
    console.log('over')
}

function dragEnter(e) {
    e.preventDefault();
    this.className += ' hovered';
}

function dragLeave() {
    this.className = 'empty';
}

function dragWrapper() {
    var wrapper = localStorage.getItem('wrapper')
    var classWrapper = document.querySelector('#wrapper');
    console.log('drop wrapper : ' + wrapper);
    if (wrapper == 'header') {
        classWrapper.append(header);
    } else if (wrapper == 'left') {
        classWrapper.append(left);
    } else if (wrapper == 'right') {
        classWrapper.append(right);
    } else if (wrapper == 'footer') {
        this.append(footer);
    }
    localStorage.removeItem('wrapper');
}

function dragJunk() {
    var junk = localStorage.getItem('junk');
    console.log('drop junk : ' + junk)
    if (junk == 'header') {
        var headerD = document.querySelector('header')
        this.append(headerD);
        console.log('header junk' + this.className)
    } else if (junk == 'main') {
        alert("Main 화면은 삭제 할 수 없습니다.")
        console.log('main junk' + this.className)
    } else if (junk == 'left') {
        var leftD = document.querySelector('left')
        this.append(leftD);
        console.log('left junk' + this.className)
    } else if (junk == 'right') {
        var rightd = document.querySelector('right')
        this.append(rightd);
        console.log('right junk' + this.className)
    } else if (junk == 'footer') {
        var footerd = document.querySelector('#footer');
        this.append(footerd);
        console.log('footer junk' + this.className);
    }
    localStorage.removeItem('junk');
}

function dragDrop(e) {
    // this.append(localStorage.getItem('file'));
    console.log('drop : ' + localStorage.getItem('file'))
    if (localStorage.getItem('file') == 'fill') {
        this.append(fill);
        console.log('fill drop success')
    }
    if (localStorage.getItem('file') == 'banner') {
        this.append(banner);
        console.log('banner drop success')
    }
    if (localStorage.getItem('file') == 'menu') {
        this.append(menu);
        console.log('menu drop success')
    }
    localStorage.removeItem('file');
}

function fillDragDrop() {
    this.className = 'empty';
    this.append(fill);
    console.log("drop fill")
}

function menuDragDrop() {
    this.className = 'empty';
    this.append(menu);
    console.log('drop menu');
}

function bannerDragDrop() {
    this.className = "empty";
    this.append(banner);
    console.log("drop banner")
}



function menuDragEnd() {
    this.className = "menu";
}

function bannerDragEnd() {
    this.className = "banner";
}

function fillDragEnd() {
    this.className = 'fill';
}
// // 쓰레기통


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

$(function() {
    $('#header').resizable();
    $('#header').draggable({
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('junk', 'header');
            localStorage.setItem('wrapper', 'header');

            console.log('start function working')
        }
    });
    $('#leftcolumn').resizable();
    $('#leftcolumn').draggable({
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('junk', 'left');
            localStorage.setItem('wrapper', 'left');

            console.log('left start function working')
        }
    });
    $('#rightcolumn').resizable();
    $('#rightcolumn').draggable({
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('junk', 'right');
            localStorage.setItem('wrapper', 'right');

            console.log('right column start function working')
        }
    })
    $('#content').resizable();
    $('#content').draggable({
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('junk', 'content');
            localStorage.setItem('wrapper', 'content');

            console.log('start function working')
        }
    })
    $('#footer').resizable();
    $('#footer').draggable({
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('junk', 'footer');
            localStorage.setItem('wrapper', 'footer ');

            console.log('start function working')
        }
    })
    $('.fill').draggable({
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('menu', 'fill');
            console.log('fill start function working')
        }
    })
    $('.menu').draggable({
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('menu', 'menu');
            console.log('start function working')
        }
    })
    $('.banner').draggable({
        start: function(event, ui ) {     //드래그를 시작했을때 이벤트 발생
            currentObj = $(".ui-draggable-dragging");
            localStorage.setItem('menu', 'banner');
            console.log('start function working')
        }
    })
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
        console.log("드롭~ ");
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
});


// $("#garbage").droppable({
//     tolerance: 'touch',
//     over: function(event, ui){
//         $(this).removeClass('out').addClass('over'); },
//     out: function(event, ui) {
//         $(this).removeClass('over').addClass('out'); },
//     drop: function(event, ui) {
//         var idVal=$(ui.draggable).attr('id');
//         console.log(idVal);
//         if ( idVal=="sample6"){
//             $('#text').show();
//         }
//
//         else if (idVal=="sample1"){
//             $("#screen").removeClass().addClass('bg1');
//         }
//         else if (idVal=="sample2"){
//             $("#block").removeClass().addClass('bg2').resizable();
//         }
//         else if (idVal=="sample3"){
//             $("#screen").removeClass().addClass('bg3');
//         }
//         else if (idVal=="sample4"){
//             $("#block").removeClass().addClass('bg4');
//             $("#sample4").resizable();
//         }
//         else if (idVal=="sample5"){
//             $("#screen").removeClass().addClass('bg5');
//         }
//
//
//     }
// });
// Fill Listeners
fill.addEventListener('dragstart', fillDragStart);
fill.addEventListener('dragend', fillDragEnd);
banner.addEventListener('dragstart', bannerDragStart);
banner.addEventListener('dragend', bannerDragEnd);
menu.addEventListener('dragstart', menuDragStart);
menu.addEventListener('dragend', menuDragEnd);
// header.on('dragstart', headerDragStart);
// header.on('dragend', headerDragEnd);
// left.on('dragstart', leftDragStart);
// left.on('dragend', leftDragEnd);
// right.on('dragstart', rightDragStart);
// right.on('dragend', rightDragEnd);
// main.on('dragstart', mainDragStart);
// main.on('dragend', mainDragEnd);
// footer.on('dragstart', footerDragStart);
// footer.on('dragend', footerDragEnd);

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
// 쓰레기통
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
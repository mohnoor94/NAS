/**
 * Created by AbuKhleif on 2017-07-07.
 */

$('.header').click(function(){
    $(this).toggleClass('expand').nextUntil('tr.header').slideToggle(100);
});

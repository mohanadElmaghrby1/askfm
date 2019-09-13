/*global $, jQuery, console, alert, prompt */
$(document).ready(function () {
	"use strict";

	   $("#upfile1").click(function () {
	   $("#file1").trigger('click');
	});

	$(".open").click(function () {
		$(".followers").slideToggle(500);
	});
	//Add - Remove Class active notifcation
    $('.filter li').click(function () {
        $(this).addClass('active').siblings('li').removeClass('active');
        $('section').hide();
        $('section.' + $(this).data('class')).fadeIn();

    });
    //Add -  Remove Class Activee From Profile
	$('.cover  .likes li').click(function () {
        $(this).addClass('activee').siblings('li').removeClass('activee');
        $('section').hide();
        $('section.' + $(this).data('class')).fadeIn();

    });
    $('.setting-account').hide();
     //Add -  Remove Class Activee From Setting
    $('.main-choice li').click(function () {
        $(this).addClass('activee').siblings('li').removeClass('activee');
        $('.profile , .setting-account').hide();
        $('.' + $(this).data('class')).fadeIn();
 
    });
    //Add -  Remove Class Selected From home
        $('.login').hide();
        $('.nav-home li').click(function () {
        $(this).addClass('select-home').siblings('li').removeClass('select-home');
        $('.signup , .login').hide();
        $('.' + $(this).data('class')).fadeIn();
    });
   
});

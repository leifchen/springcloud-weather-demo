/**
 * report页面下拉框事件
 */
$(function () {
    $("#selectCityId").change(function () {
        let cityId = $("#selectCityId").val();
        let url = '/report/cityId/' + cityId;
        window.location.href = url;
    })
});
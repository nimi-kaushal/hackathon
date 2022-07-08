let colors = {
    pharmacyColor: '#cb1e44',
    privateColor: '#77878a'
}

let svgMarkerPath = "M12,2C8.1,2,5,5.1,5,9c0,5.3,7,13,7,13s7-7.8,7-13C19,5.1,15.9,2,12,2z";

function getDefaultSvgMarker(fillColor, strokeColor) {
    return {
        path: svgMarkerPath,
        strokeWeight: 4,
        fillColor: fillColor,
        fillOpacity: 0.9,
        scale: 1.7,
        strokeColor: strokeColor,
        anchor: {x: 12, y: 22},
    };
}

function getEmployeesLegend() {
    var legend = document.createElement("div");
    legend.id = "legend";
    legend.style.cssText = "border-radius: 2px; background: white; padding: 3px; margin: 10px; box-shadow: rgb(0 0 0 / 30%) 0px 1px 4px -1px; diplay:none";
    var div = document.createElement("div");
    div.style.cssText = 'display: flex; align-content: center; align-items: center; padding: 10px;'
    div.innerHTML = '<svg height="22" width="26"> <path style="fill: ' + colors.pharmacyColor + ';" d="' + svgMarkerPath + '" /></svg><p> Pharmacy</p>';
    legend.appendChild(div);
    div = document.createElement("div");
    div.style.cssText = 'display: flex; align-content: center; align-items: center; padding: 10px;'
    div.innerHTML = '<svg height="22" width="26"> <path style="fill: ' + colors.privateColor + ';" d="' + svgMarkerPath + '" /></svg><p> User</p>';
    legend.appendChild(div);
    div = document.createElement("div");
    div.style.cssText = 'display: flex; align-content: center; align-items: center; padding: 10px;'
    legend.appendChild(div)
    return legend;
}

function getStoreDescription(name, distance, address, phone, storeId, drugName) {
    return '<div style="align-content: center; align-items: center; text-align: center;" id="content">' +
        '<h4>' + name + '</h4>' +
        '<div id="bodyContent">' +
        '<p><span style="padding: 3px; border-radius: 3px; font-size: 11.844px; font-weight: bold; line-height: 14px; color: #ffffff; text-shadow: 0 -1px 0 rgb(0 0 0 / 25%); white-space: nowrap; vertical-align: baseline;background-color: ' + '#f577ff' + '">' + distance + '</span> ' +
        "<p>" + phone + "</p>" +
        "<p>" + address.toString() + "</p>" +
        "</div>" +
        '<button className= "btn btn-primary" onClick=reserveDrug(' + storeId + ',' + drugName + ')>Reserve </button>'
        + "</div>";
}


function getFillColorByType(role) {
    var fillColor = colors.userColor;
    switch (role) {
        case 'PHARMACY':
            fillColor = colors.adminColor;
            break;
    }
    return fillColor;

}


function reserveDrug(storeId, drugName) {
//"storeId :" + storeId + ", drugName : " + drugName;

    var data = '{"storeId":' + storeId + ', }';

    $.ajax({
        url: 'http://localhost:8080/api/orders/reserve',
        type: "POST",
        data: data,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function () {

        }
    })

    alert(storeId);

}




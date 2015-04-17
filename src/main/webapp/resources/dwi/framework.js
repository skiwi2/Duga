/**
 * Created by Frank van Heeswijk on 16-4-2015.
 */

$(document).ajaxError(function(event, jqxhr, settings, thrownError) {
    alert("unexpected error: " + thrownError);
    console.log(jqxhr.responseText);
});

function showNormal(fragmentName) {
    console.log(getLocation() + "/fragment/" + fragmentName + "/normal");
    loadFragmentInto(getLocation() + "/fragment/" + fragmentName + "/normal", fragmentName);
}

function showEdit(fragmentName) {
    loadFragmentInto(getLocation() + "/fragment/" + fragmentName + "/edit", fragmentName);
}

function loadFragmentInto(fragmentUrl, elementId) {
    $.get(fragmentUrl, function (data) {
        $("#" + elementId).html(data);
    });
}

function saveFragment(fragmentName) {
    var fragmentUrl = getLocation() + "/fragment/" + fragmentName + "/edit";
    $.post(fragmentUrl, serializeForm(fragmentName), function(data) {
        showNormal(fragmentName);
    });
}

function saveFragmentAndThen(fragmentName, thenFunction) {
    var fragmentUrl = getLocation() + "/fragment/" + fragmentName + "/edit";
    $.post(fragmentUrl, serializeForm(fragmentName), function(data) {
        if (typeof thenFunction === 'function') {
            thenFunction();
        }
    });
}


function getLocation() {
    return location.href.replace(/\/$/, "").replace(/#$/, "");
}

function serializeForm(fragmentName) {
    return $("#" + fragmentName + "_form").serialize();
}
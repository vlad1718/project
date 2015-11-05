

var capsLockEnabled = null;

function getChar(event) {
    if (event.which != 0 && event.charCode != 0) {
        if (event.which < 32) return null;
        return String.fromCharCode(event.which)
    }

    return null;
}


document.onkeypress = function(e) {
    e = e || event;

    var chr = getChar(e);
    if (!chr) return

    if (chr.toLowerCase() == chr.toUpperCase()) {

        return;
    }

    capsLockEnabled = (chr.toLowerCase() == chr && e.shiftKey) || (chr.toUpperCase() == chr && !e.shiftKey);
}


function checkCapsWarning() {
    document.getElementById('capsIndicator').style.display = capsLockEnabled ? 'block' : 'none';
}

function removeCapsWarning() {
    document.getElementById('capsIndicator').style.display = 'none';
}

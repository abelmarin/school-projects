const stringsToHash = function(s1,s2) {
    if (s1.length === 0 || s2.length === 0) return 0;

    var hash = s1.length;

    for (var i = 0; i < s1.length; i++) {
        var char1 = s1.charCodeAt(i);
        hash = ((hash << 5) - hash) + char1;
    }

    for (var j = 0; j < s2.length; j++) {
        var char2 = s2.charCodeAt(j);
        hash = ((hash << 5) - hash) + char2;
    }

    return hash;
}

export default stringsToHash;
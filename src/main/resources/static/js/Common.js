

function get_url_values(){
    var ret=[],hash;
    var hashes=window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i=0;i<hashes.length;i++){
        hash=hashes[i].split('=');
        ret.push(hash[0]);
        ret[hash[0]]=hash[1];
    }
    return ret
}
var url;
url = "http://localhost:8881/";
// url = "http://jt rsr.natappfree.cc/";
function get_nap(){
    return url;
}
function get_nap_html(){
    return "http://localhost:63342/backstage/static";
}
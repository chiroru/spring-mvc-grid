jQuery.extend({
    stringify : function stringify(obj) {
        var t = typeof (obj);
        if (t != "object" || obj === null) {
            // simple data type
            if (t == "string") obj = '"' + obj + '"';
            return String(obj);
        } else {
            // recurse array or object
            var n, v, json = [], arr = (obj && obj.constructor == Array);
 
            for (n in obj) {
                v = obj[n];
                t = typeof(v);
                if (obj.hasOwnProperty(n)) {
                    if (t == "string")
                        v = '"' + v + '"';
                    else if (t == "object" && v !== null)
                        v = jQuery.stringify(v);
                    else if (t == "function" && v !== null)
                        v = '"' + v() + '"';
                    json.push((arr ? "" : '"' + n + '":') + String(v));
                }
            }
            var request = (arr ? "[" : "{") + String(json) + (arr ? "]" : "}");
            return request;
        }
    }
});

jQuery(document).ready(function() {
    function viewModel() {
        var self = this;

        self.id = "grid";

        self.items = ko.observableArray([
                       { name: ko.observable("name1"), address: ko.observable("address1") },
                       { name: ko.observable("name2"), address: ko.observable("address2") }
                       ]);

        self.update = function() {
        	var d = self.items.splice(0);
            var gf = jQuery("#gridForm");
            jQuery.ajax({
                headers: { 
                    'Accept': 'application/json',
                    'Content-Type': 'application/json' 
                },
                url : gf.attr("action"),
                type : "POST",
                dataType : 'json',
                data : jQuery.stringify(d),
                contentType: "application/json; charset=utf-8",
                success : function(messages) { alert(jQuery.stringify(messages)); console.log(messages); for (var i in messages) {self.items.push(messages[i])};},
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest);
                    console.log(textStatus);
                    console.log(errorThrown);
                    alert(textStatus);
                }
            });
        };
    }

    ko.applyBindings(new viewModel());

});
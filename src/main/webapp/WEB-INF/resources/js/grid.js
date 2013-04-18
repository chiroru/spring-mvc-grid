jQuery(document).ready(function() {
  function viewModel() {
	var self = this;
    
	self.id = "grid";
	
	self.items = ([
        { name: "name1", address: "address1" },
        { name: "name2", address: "address2" }
    ]);

	console.log(self.items);
    
    self.reset = function() {
    	console.log(self.id);
		console.log(self.items);
	}
  }

  ko.applyBindings(new viewModel());

});
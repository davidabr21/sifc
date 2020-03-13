				let table;
				$(document).ready(function() {
				    // Setup - add a text input to each footer cell
				    $('.main-grid thead tr').clone(true).appendTo( '.main-grid thead' );
				    let sizecolumns;
				    $('.main-grid thead tr:eq(1) th').each( function (i) {sizecolumns = i});
				    
				    $('.main-grid thead tr:eq(1) th').each( function (i) {
				    	if(i < (sizecolumns - 1) && i != 0){
				        var title = $(this).text();
				        $(this).html( '<input type="text" class="form-control" style="width: 100%" placeholder="'+title+'" />' );
				 
				        $( 'input', this ).on( 'keyup change', function () {
				            if ( table.column(i).search() !== this.value ) {
				                table
				                    .column(i)
				                    .search( this.value )
				                    .draw();
				            }
				        } );
				    	}
				    } );
				 
				    table = $('.main-grid').DataTable( {
				    	scrollY: "200px",
				    	"scrollY":        "200px",
				        orderCellsBottom: true,
				        "paging": false
				    } );
			    	$('.prospectogrid tbody').on('click', 'tr', function () {
			    		var data = table.row( this ).data();
			    		let fromValue = $("input[name='prospectoForm\\:emailFrom']").val();
			    		let elemnt = document.createElement("div");
			    		elemnt.innerHTML = data[0];
			    		let mailValue = elemnt.innerText;
			    		$("input[name='prospectoForm\\:emailFrom']").val(mailValue);
			    		$(".prsName").val(data[1]);
			    	} );
				} );
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
				    	"scrollX": true,
				        orderCellsBottom: true,
				        fixedHeader: true,
				        dom: 'Bfrtip',
				        buttons: [
				            {
				                extend: 'excel',
				                exportOptions: {
				                    modifier: {
				                        page: 'current'
				                    }
				                }
				            },
				            {
				                extend: 'pdf',
				                exportOptions: {
				                    modifier: {
				                        page: 'current'
				                    }
				                }
				            }
				        ]
				    } );
				    
				    	$('.main-grid tbody').on('click', 'tr', function () {
				    		if(isActive){
				    		var data = table.row( this ).data();
				    		let fromValue = $('.emailFrom').val();
				    		let elemnt = document.createElement("div");
				    		elemnt.innerHTML = data[4];
				    		let mailValue = elemnt.innerText;
				    		
				    		if(fromValue == ""){
				    			$('.emailFrom').val(fromValue + mailValue);
				    		} else{
				    			$('.emailFrom').val(fromValue + ", " + mailValue);				        	
				    		}
				    		}
				    	} );
				} );
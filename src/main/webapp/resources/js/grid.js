				let table;
				$(document).ready(function() {
				    // Setup - add a text input to each footer cell
				    $('.main-grid thead tr').clone(true).appendTo( '.main-grid thead' );
				    let sizecolumns;
				    $('.main-grid thead tr:eq(1) th').each( function (i) {sizecolumns = i});
				    
				    $('.main-grid thead tr:eq(1) th').each( function (i) {
				    	if(i < (sizecolumns - 1) && i != 0){
				        var title = $(this).text();
				        $(this).html( '<input type="text" class="form-control" style="max-width: 320px; min-width: 120px" placeholder="'+title+'" />' );
				 
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
				        "autoWidth": false,
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
				} );
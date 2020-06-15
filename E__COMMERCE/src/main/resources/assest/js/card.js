
	function insertcart(id,title,price)
	 {
		let cart=localStorage.getItem("cart");
		if(cart==null)
			{
			  let products=[];
			  let product={ProductId:id,ProductName:title,ProductQuantity:1,ProductPrice:price};
			  products.push(product);
			  localStorage.setItem("cart",JSON.stringify(products));//
			  alert("new product added");
			}
		else
			{

			   let pcart=JSON.parse(cart);// string convert into array
			   let oldproduct= pcart.find((item)=> item.ProductId==id)
			   if(oldproduct)
		    	 {
			    	 oldproduct.productQantity=oldproduct.productQantity+1;
			    	 pcart.map((item)=>
			    	 {
				    	 if(item.ProductId==oldproduct.ProductId)
					    	 {
					    	    item.ProductQuantity=oldproduct.ProductQuantity;
					    	 }
				    })
				    localStorage.setItem("cart",JSON.stringify(pcart));
					alert("product increased");
			    	 // we have to increase the quantity
	            }
			   else
				   {
				       // we have to add product
				        let product={ProductId:id,ProductName:title,ProductQuantity:1,ProductPrice:price};
				        pcart.push(product);
				        localStorage.setItem("cart",JSON.stringify(pcart));
				        alert("different product added");
				   }

			}
		 updatecart();
	}
	
	function updatecart()
	{
        let cartString=localStorage.getItem("cart");
        let cart=JSON.parse(cartString);

        if(cart==null ||cart.length==0)
        {
           console.log("cart is empty!");
           $(".card-item").html("( 0 )");
           $(".cart-body").html("<h3>cart does not have any items</h3>")
           $(".checkout-btn").addClass("disabled");
        }
        else
         {
        	  $(".card-item").html(`(${cart.length})`);
        	  let table=`
            	  <table class='table'>
            	  <thead class='thead-light'>
            	  <tr>
            	  <th>Item name</th>
            	  <th>Item price</th>
            	  <th>Item quantity</th>
            	  <th>totle price</th>
            	  <th>action</th>
            	  </tr>
            	  </head>
            	  `;
            	  cart.map((item)=>
            	   {
                        table+=`
                             <tr>
                              <td>${item.ProductName}</td>
                              <td>${item.ProductPrice}</td>
                              <td>${item.ProductQuantity}</td>
                              <td>${item.ProductQuantity * item.ProductPrice}</td>
                              <td><button onclick='deleteitemfromcart(${item.ProductId})' class="btn btn-danger btn-sm">Remove</button></td>
                              </tr>
                            `;
                        //totalprice+=item.ProductPrice * item.ProductQuantity;

                   })
            	  table=table+`</table>`;
            	  $(".cart-body").html(table);
            	  $(".checkout-btn").removeClass("disabled");
         } 
        //<tr><td colspan='5' class='text-right font-weight-bold'>Totle price:${totalprice}</td></tr>
	}
	function deleteitemfromcart(pid)
	{
		let cart=JSON.parse(localStorage.getItem("cart"));
		let newcart=cart.filter((item)=>item.ProductId!=pid);
		localStorage.setItem("cart",JSON.stringify(newcart));
		
		updatecart();
	}
	
	$("document").ready(function(){updatecart();})

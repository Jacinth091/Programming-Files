const cart = ['Banana', 'Apple', 'Orange', 'Grapes'];
function UserCart(){

    const sortedCart = cart.sort((a, b) => a.localeCompare(b));
    
    return(         
        <div>
            <p>Your Shopping Cart:</p>
            <ul>
                {cart.map((item, index) => (
                <li key={index}>{item}</li>
                ))}
            </ul>
        </div>

    );
    

}

export default UserCart;
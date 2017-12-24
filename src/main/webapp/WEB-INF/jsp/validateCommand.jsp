<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
    <input type="hidden" name="business" value="EyllanAlbion@gmail.com">
    <input type="hidden" name="cmd" value="_xclick">
    <input type="hidden" name="item_name" value="command">
    <input type="hidden" name="amount" value="${totalCostAllReducInclusive}">
    <input type="hidden" name="currency_code" value="EUR">
    <input type='hidden' name='return' value='http://localhost:8081/transAirPort/validateCommand/success' />
    <input type="image" name="submit" border="0" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif" alt="PayPal - The safer, easier way to pay online">
</form>
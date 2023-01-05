package sg.edu.nus.iss.app.ssfworkshop13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.app.ssfworkshop13.models.Cart;
import sg.edu.nus.iss.app.ssfworkshop13.models.Item;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

    @GetMapping()
    public String getCart(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            // session storage on server
            session.setAttribute("cart", cart);
        }

        // make cart and item available to html side
        model.addAttribute("item", new Item());
        model.addAttribute("cart", cart);
        return "cart";
    }

    // @Valid checks if the item is valid
    // @BindnigResult enables error checking
    @PostMapping()
    public String postData(Model model, HttpSession session, @Valid Item item, BindingResult binding) {

        Cart cart = (Cart) session.getAttribute("cart");

        if (binding.hasErrors()) {
            model.addAttribute("item", item);
            model.addAttribute("cart", cart);
            return "cart";
        }

        cart.addItemToCart(item);

        // send item obj back to page
        model.addAttribute("item", item);
        model.addAttribute("cart", cart);
        return "cart";
    }
}

<template>
    <nav class="main-menu d-flex navbar navbar-expand-lg p-2 py-3 p-lg-4 py-lg-4 ">
        <div class="container-fluid">
            <div class="main-logo d-lg-none">
                <a href="index.html">
                    <img src="images/logo.png" alt="logo" class="img-fluid">
                </a>
            </div>

            <button class="navbar-toggler shadow-none" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
                aria-labelledby="offcanvasNavbarLabel">

                <div class="offcanvas-header mt-3">
                    <button type="button" class="btn-close shadow-none" data-bs-dismiss="offcanvas"
                        aria-label="Close"></button>
                </div>

                <div class="offcanvas-body justify-content-between">
                    <div class="main-logo">
                        <a href="index.html">
                            <img src="images/logo.png" alt="logo" class="img-fluid">
                        </a>
                    </div>

                    <ul class="navbar-nav menu-list list-unstyled align-items-lg-center d-flex gap-md-3 mb-0">
                        <li class="nav-item">
                            <a href="index.html" class="nav-link mx-2 active">Home</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link mx-2 dropdown-toggle align-items-center" role="button" id="pages"
                                data-bs-toggle="dropdown" aria-expanded="false">Pages</a>
                            <ul class="dropdown-menu" aria-labelledby="pages">
                                <li><a href="about.html" class="dropdown-item">About Us</a></li>
                                <li><a href="instructors.html" class="dropdown-item">Instructors</a></li>
                                <li><a href="cart.html" class="dropdown-item">Cart</a></li>
                                <li><a href="wishlist.html" class="dropdown-item">Wishlist</a></li>
                                <li><a href="checkout.html" class="dropdown-item">Checkout</a></li>
                                <li><a href="price-plan.html" class="dropdown-item">Price Plan</a></li>
                                <li><a href="contact.html" class="dropdown-item">Contact</a></li>
                                <li><a href="faqs.html" class="dropdown-item">FAQs</a></li>
                                <li><a href="account.html" class="dropdown-item">Account</a></li>
                                <li><a href="thank-you.html" class="dropdown-item">Thankyou</a></li>
                                <li><a href="error.html" class="dropdown-item">Error 404</a></li>
                                <li><a href="styles.html" class="dropdown-item">Styles</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link mx-2 dropdown-toggle align-items-center" role="button" id="courses"
                                data-bs-toggle="dropdown" aria-expanded="false">Courses</a>
                            <ul class="dropdown-menu" aria-labelledby="courses">
                                <li><a href="courses.html" class="dropdown-item">Course</a></li>
                                <li><a href="courses-details.html" class="dropdown-item">Courses Detail</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link mx-2 dropdown-toggle align-items-center" role="button" id="events"
                                data-bs-toggle="dropdown" aria-expanded="false">events</a>
                            <ul class="dropdown-menu" aria-labelledby="courses">
                                <li><a href="event.html" class="dropdown-item">event</a></li>
                                <li><a href="event-details.html" class="dropdown-item">event details</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link mx-2 dropdown-toggle align-items-center" role="button" id="blog"
                                data-bs-toggle="dropdown" aria-expanded="false">blog</a>
                            <ul class="dropdown-menu" aria-labelledby="blog">
                                <li><a href="blog.html" class="dropdown-item">blog</a></li>
                                <li><a href="single-post.html" class="dropdown-item">single post</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link mx-2 dropdown-toggle align-items-center" role="button" id="shop"
                                data-bs-toggle="dropdown" aria-expanded="false">shop</a>
                            <ul class="dropdown-menu" aria-labelledby="shop">
                                <li><a href="shop.html" class="dropdown-item">Shop</a></li>
                                <li><a href="single-product.html" class="dropdown-item">Single Product</a></li>
                            </ul>
                        </li>

                        <li class="nav-item">
                            <a href="contact.html" class="nav-link mx-2">contact</a>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link mx-2 text-decoration-underline" target="_blank">Button</a>
                        </li>
                    </ul>

                    <div class="d-none d-lg-flex align-items-center">
                        <ul class="d-flex  align-items-center list-unstyled m-0">
                            <li>
                                <a href="account.html" class="ms-3">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="22px" height="22px">
                                        <use href="#user-circle" />
                                    </svg> </a>
                            </li>
                            <li>
                                <a href="wishlist.html" class="ms-3">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="22px" height="22px">
                                        <use href="#heart" />
                                    </svg> </a>
                            </li>

                            <li class="">
                                <a href="#" class="ms-3" data-bs-toggle="offcanvas" data-bs-target="#offcanvasCart"
                                    aria-controls="offcanvasCart">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="22px" height="22px">
                                        <use href="#shopping-bag" />
                                    </svg> </a>
                            </li>

                            <li>
                                <a href="#" class="ms-3" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSearch"
                                    aria-controls="offcanvasSearch">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="22px" height="22px">
                                        <use href="#search" />
                                    </svg> </a>
                            </li>

                        </ul>
                    </div>

                </div>
            </div>

        </div>
        <div class="container-fluid d-lg-none">
            <div class="d-flex  align-items-end mt-3">
                <ul class="d-flex  align-items-center list-unstyled m-0">
                    <li>
                        <a href="account.html" class="me-3">
                            <svg xmlns="http://www.w3.org/2000/svg" width="22px" height="22px">
                                <use href="#user-circle" />
                            </svg> </a>
                    </li>
                    <li>
                        <a href="wishlist.html" class="me-3">
                            <svg xmlns="http://www.w3.org/2000/svg" width="22px" height="22px">
                                <use href="#heart" />
                            </svg> </a>
                    </li>

                    <li class="">
                        <a href="#" class="me-3" data-bs-toggle="offcanvas" data-bs-target="#offcanvasCart"
                            aria-controls="offcanvasCart">
                            <svg xmlns="http://www.w3.org/2000/svg" width="22px" height="22px">
                                <use href="#shopping-bag" />
                            </svg> </a>
                    </li>

                    <li>
                        <a href="#" class="me-3" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSearch"
                            aria-controls="offcanvasSearch">
                            <svg xmlns="http://www.w3.org/2000/svg" width="22px" height="22px">
                                <use href="#search" />
                            </svg> </a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
</template>
from django.db import models


# Create your models here.

def Product():
    product_name = models.CharField(max_length=255)

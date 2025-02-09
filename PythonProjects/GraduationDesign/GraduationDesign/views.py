
from django.http import HttpResponse
from django.views import View

class SearchRequest(View):
    def get(self, request):

        return HttpResponse("Hello, world. You're at the search request.")

    def post(self, request):
        return HttpResponse("Hello, world. You're at the search request.")
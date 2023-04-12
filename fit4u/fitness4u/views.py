from django.shortcuts import render

def home(request):
    return render(request, 'home.html', {'page_title': 'Welcome to My App'})
# Create your views here.

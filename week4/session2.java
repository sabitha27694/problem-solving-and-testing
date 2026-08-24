int window = 0;

for (int i = 0; i < k; i++) {
    window += arr[i];
}

int ans = window;

for (int i = k; i < arr.length; i++) {
    window += arr[i];
    window -= arr[i - k];

    ans = Math.max(ans, window);
}

System.out.println(ans);
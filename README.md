# FragmentOptionMenu

```java
public class FirstFragment extends Fragment {

    ...

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(requireContext(), "Menu 1 ", Toast.LENGTH_SHORT).show();
                Fragment fragment = new Menu1Fragment();
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fr_1, fragment)
                        .commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/menu1"
        android:title="Menu 1"/>
</menu>
```

---

```
Copyright 2022 M. Fadli Zein
```
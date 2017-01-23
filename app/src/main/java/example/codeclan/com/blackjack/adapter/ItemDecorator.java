package example.codeclan.com.blackjack.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by user on 23/01/2017.
 */

public class ItemDecorator extends RecyclerView.ItemDecoration {
    private final int mSpace;

    public ItemDecorator(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final int itemPosition = parent.getChildAdapterPosition(view);
        if (itemPosition == 0) {
            return;
        }

        outRect.left = mSpace;
    }
}

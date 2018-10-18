//Shift+space
/**
    直接插入
    折半插入
    希尔插入

    冒泡排序
    快速排序

    简单选择排序
    堆排序
    归并排序
 */
void InsertSort(ElemType A[],int n){
    int i,j;
    for(i=2;i<=n;i++){
        if(A[i].key<A[i-1].key){
            A[0] = A[i];
            for(j=i-1;A[0].key>A[j].key;j--){
                A[j+1] = A[j];
            }
            A[j+1] = A[0];
        }
    }
}

void InsertSort(ElemType A[],int n){
    int i,j;
    for(i=2;i<=n;i++){
        if(A[i].key<A[i-1].key){
            A[0] = A[i];
            for(j=i-1;A[j].key>A[0].key)
                A[j+1] = A[j];
            A[j+1] = A[0];
        }
    }
}

void InsertSort(ElemType A[],int n){
    for(i=2;i<=n;i++){
        if(A[i].key<A[i-1].key){
            A[0] = A[i];
            for(j=i-1;j>0&&A[j].key>A[0].key;j--)
                A[j+1] = A[j];
            A[j+1] = A[0];
        }
    }
}

void InsertSort(ElemType A[],int n){
    for(i=2;i<=n;i++){
        A[0] = A[i];
        low = 1;
        hign = i-1;
        while(low<high){
            mid = (low+high)/2;
            if(A[mid].key<A[0].key)
                low = mid+1;
            else
                high = mid-1;
        }
        for(j=i-1;j>high+1;j--)
            A[j+1] = A[j];
        A[j+1] = A[0];
    }
}

void InsertSort(ElemType A[],int n){
    int i,j,low,high,mid;
    for(i=2;i<=n;i++){
        A[0] = A[i];
        low=1;
        high=i-1;
        while(low<high){
            mid=(low+high)/2;
            if(A[mid]<A[0])
                low = mid+1;
            else
                high= mid-1;
        }
        for(j=i-1;j>=high+1;j--)
            A[j+1] = A[j];
        A[high+1] = A[0]; 
    }
}

void InsertSort(ElemType A[],int n){
    int i,j,low,high,mid;
    for(i=2;i<=n;i++){
        A[0] = A[i];
        low=1;
        high=i-1;
        while(low<high){
            mid=(low+high)/2;
            if(A[0]>A[mid])
                high=mid-1;
            else
                low=mid+!;
        }
        for(j=i-1;j<high+1;--j){
            A[j+1] = A[j];
        }
        A[high+1] = A[0];
    }
}

void ShellSort(ElemType A[],int n){
    for(dk=n/2;dk>=1;dk/=2){
        for(i=dk+1;i<=n;i++){
            if(A[i].key<A[i-dk].key){
                A[0] = A[i];
                for(j=i-dk;j>0&&A[j].key>A[0].key;j-=dk)
                    A[j+dk] = A[j];
                A[j+dk] = A[0];
            }
        }
    }
}

void ShellSort(ElemType A[],int n){
    for(dk=n/2;dk>=1;dk/=2){
        for(i=dk+1;i<=n;i++){
            if(A[i].key<A[i-dk].key){
                A[0] = A[i];
                for(j=i-dk;j>0&&A[j].key>A[].key;j-=dk)
                    A[j+dk] = A[j];
                A[j+dk] = A[0];
            }
        }
    }
}

void ShellSort(ElemType A[],int n){
    for(dk=n/2;dk>=1;dk/=2){
        for(i=dk+1;i<=n;i++){
            if(A[i].key<A[i-dk].key){
                A[0] = A[i];
                for(j=i-dk;j>0&&A[j].key>A[0].key;j-=dk)
                    A[j+dk] = A[j];
                A[j+dk] = A[0];
            }
        }
    }
}

void BubbleSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        flag=false;
        for(j=n-1;j>i;j--){
            if(A[j-1].key>A[j].key){
                swap(A[j-1],A[j]);
                flag = true;
            }
            if(flag==false)
                return;
        }
    }
}

void BubbleSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        for(j=n-1;j>i;j--){
            if(A[j-1].key>A[j].key){
                swap(A[j-1],A[j]);
                flag = true;
            }
            if(flag == false)
                return;
        }
    }
}

void BubbleSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        for(j=n-1;j>i;j--){
            if(A[j-1].key>A[j].key){
                swap(A[j-1],A[j]);
                flag = true;
            }
            if(falg == false)
                return;
        }
    }
}

void QuickSort(ElemType A[],int low,int high){
    if(low<high){
        int pivotpos = Partition(A,low,high);
        QuickSort(A,low,pivotpos-1);
        QuickSort(A,pivotpos+1,high);
    }
}
int Partition(ElemType A[],int low,int high){
    ElemType pivot = A[low];
    while(low<high){
        while(low<high&&A[high]>=pivot)
            --high;
        while(low<high&&A[low]<=pivot)
            ++low;
    }
    A[low] = pivot;
    return low;
}

void QuickSort(ElemType A[],int n){
    if(low<high){
        int pivotpos = Partition(A,low,high);
        QuickSort(A,low,pivotpos-1);
        QuickSort(A,pivotpos+1,high);
    }
}
int Partition(ElemType A[],int low,int high){
    ElemType pivot = A[low];
    while(low<high){
        while(low<high&&A[high]>=pivot)
            --high;
        while(low<high&&A[low]>=pivot)
            ++low;
    }
    A[low] = pivot;
    return low;
}

void QuickSort(ElemType A[],int n){
    if(low<high){
        int pivotpos = Partition(A,low,high);
        QuickSort(A,low,pivotpos-1);
        QuickSort(A,pivotpos+1,high);
    }
}
int Partition(ElemType A[],int low,int high){
    ElemType pivot = A[low];
    while(low<high){
        while(low<high&&A[high]>=pivot)
            --high;
        while(low<high&&A[low]>=pivot)
            ++high;
    }
    A[low] = pivot;
    return low;
}

void SelectSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        min=i;
        for(j=i+1;j<n;j++){
            if(A[j]<A[min])
                ming =j;
        }
        if(min!=i)
            swap(A[i],A[min]);
    }
}

void SelectSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        min = i;
        for(j=i+1;j<n;j++){
            if(A[j]<A[min])
                min = j;
        }
        if(min!=i)
            swap(A[i],A[min]);
    }
}

void SelectSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        min = i;
        for(j=i+1;j<n;j++){
            if(A[j]<A[min])
                min = j;
        }
        if(min!=i)
            swap(A[i],A[min]);
    }
}

void BuildMaxHeap(ElemType A[],int len){
    for(i=len/2;i>0;i--){
        AdjustDown(A,i,len);
    }
}
void AdjustDown(ElemType A[],int k,int len){
    A[0] = A[k];
    for(i=2*k;i<=len;i*=2){
        if(A[i+1]<A[i])
            i++;
        if(A[0]>=A[i])
            break;
        else{
            A[k] = A[i];
            k=i;
        }
    }
    A[k] = A[0];
}
void HeapSort(ElemType A[],int len){
    BuildMaxHeap(A,len);
    for(i=len;i>1;i--){
        Swap(A[i],A[1]);
        AdjustDown(A,1,i-1);
    }
}

void BuildMaxHeap(ElemType A[],int len){
    for(i=len/2;i>0;i--){
        AdjustDown(A,i,len);
    }
}
void AdjustDown(ElemType A[],int k,int len){
    A[0] = A[k];
    for(i=2*k;i<=len;i*=2){
        if(A[i+1]>A[i])
            i++;
        if(A[0]>A[i])
            break;
        else{
            A[k] = A[i];
            k=i;
        }
    }
    A[k] = A[0];
}
void HeapSort(ElemType A[],int len){
    BuildMaxHeap(A,len);
    for(i=len;i>1;i--){
        swap(A[i],A[1]);
        AdjustDown(A,1,i-1);
    }
}

void BuildMaxHeap(ElemType A[],int len){
    for(i=len/2;i>0;i--){
        AdjustDown(A,i,len);
    }
}
void AdjustDown(ElemType A[],int k,int len){
    A[0] = A[k];
    for(i=2*k;i<=len;i*=2){
        if(A[i+1]>A[i])
            i++;
        if(A[i]<A[0])
            break;
        else{
            A[k] = A[i];
            k = i;
        }
    }
    A[k] = A[0];
}

void Merge(ElemType A[],int low,int mid,int high){
    for(int k=low;k<=high;k++){
        B[k] = A[k];
    }
    for(i=low;j=mid+1,k=i;i<=mid&&j<=high;k++){
        if(B[i]<=B[j])
            A[k] = B[i++];
        else
            A[k] = B[j++];
    }
    while(i<=mid)
        A[k++] = B[i++];
    while(j<=high)
        A[k++] = B[j++];
}
void MergeSort(ElemType A[],int low,int high){
    if(low<high){
        int mid = (low+high)/2;
        MergeSort(A,low,mid);
        MergeSort(A,mid+1,high);
        Merge(A,low,mind,high);
    }
}

void Merge(ElemType A[],int low,int mid,int high){
    for(int k=low;k<=high;k++){
        B[k] = A[k];
    }
    for(i=low;j=mid+1;k=i;i<=mid&&j<=high;k++){
        if(B[i]<=B[j])
            A[k] = B[i++];
        else
            A[k] = B[j++];
    }
    while(i<=mid)
        A[k++] = B[i++];
    while(j<=high)
        A[k++] = B[j++];
}
void MergeSort(ElemType A[],int low,int mid,int high){
    if(low<high){
        int mid = (low+high)/2;
        MergeSort(A,low,mid);
        MergeSort(A,mid+1,high);
        Merge(A,low,mid,high);
    }
}

void Merge(ElemType A[],int low,int mid,int high){
    for(i=low;i<=high;i++){
        B[i] = A[i];
    }
    for(i=low,j=mid+1,k=1;i<=mid&&j<=high;k++){
        if(B[i]<B[j])
            A[k] = B[i++];
        else
            A[k] = B[j++];
    }
    while(i<=mid)
        A[k++] = B[i++];
    while(j<=high)
        A[k++] = B[j++];
}

void InsertSort(ElemType A[],int n){
    for(i=2,i<=n;i++){
        if(A[i].key<A[i-1].key){
            A[0] = A{i];
            for(j=i-1;A[j].key>A[0].j--)
                A[j+1] = A[j];
            A[j+1] = A[0];
        }
    }
}
void InsertSort(ElemType A[],int n){
    int i,j,low,high,mid;
    for(i=2;i<=n;i++){
       A[0] = A[i];
       low=1;
       high=i-1;
        while(low<=high){
            mid=(low+high)/2;
            if(A[mid].key>A[0].key)
                high = mid-1;
            else
                low = mid+1;
        }
        for(j=i-1;j>=high+!;j--)
            A[j+1] = A[j];
        A[j+1] + A[high+1];
    }
}
void InsertSort(ElemType A[],int n){
    int i,j,low,high,mid;
    for(i=2;i<=n;i++){
        A[0] = A[i];
        low=1;
        high=i-1;
        while(low<=high){
            mid = (low+high)/2;
            if(A[mid].key>A[0].key)
                high=mid-1;
            else
                low=mid+1;
        }
        for(j=i-1;j>=high+1;j--)
            A[j+1] = A[j];
        A[high+1] = A[0];
    }
}
void ShellSort(ElemType A[],int n){
    for(dk=n/2;dk>=1;dk/=2){
        for(i=dk+1;i<=n;i++){
            if(A[i].key<A[i-dk].key){
                A[0] = A[i];
                for(j=i-dk;j>0&&A[j].key>A[0].key;j-=dk)
                    A[j+dk] = A[j];
                A[j+dk] = A[0];
            }
        }
    }
}
void ShellSort(ElemType A[],int n){
    for(dk=n/2;dk>=1;dk/=2){
        for(i=dk+1;i<=n;i++){
            if(A[i].key<A[i-dk].key){
                A[0] = A[i];
                for(j=i-dk;j>0&&A[j].key>A[0].key;j-=dk)
                    A[j+dk] = A[j];
                A[j+dk] = A[0];
            }
        }
    }
}
void BubbleSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        flag = flase;
        for(j=n-1;j>i;j--){
            if(A[j].key<A[j-1].key){
                swap(A[j],A[j-1]);
                flag = true;
            }
        }
        if(flag==false)
            return;
    }
}
void BubbleSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        flag = false;
        for(j=n-1;j>i;j--){
            if(A[j].key<A[j-1].key){
                swap(A[j],A[j-1]);
                flag=true;
            }
        }
        if(flag==false)
            return;
    }
}
void QuickSort(ElemType A[],int low,int high){
    if(low<high){
        int pivotpos = Partition(A,low,high);
        QuickSort(A,low,pivotpos-1);
        QuickSort(A,pivotpos+1,high);
    }
}
int Partition(ElemType A[],int low,int high){
    if(low<high){
        ElemType pivot = A[low];
        while(low<high){
            while(low<high&&A[high]>=pivot)
                --high;
            while(low<high&&A[low]<=pivot)
                ++low;
        }
        A[low] = pivot;
        return low;
    }
}

void QuickSort(ElemType A[],int low,int high){
    if(low<high){
        int pivotpos = Partition(A,low,high);
        QuickSort(A,low,pivotpos-1);
        QuickSort(A,pivotpos+1,high);
    }
}
int Partition(ElemType A[],int low,int high){
    ElemType A = A[low];
    while(low<high){
        while(low<high&&A[high].key>=pivot)
            high--;
        while(low<high&&A[low].key<=pivot)
            low++;
    }
    A[low] = pivot;
    return low;
}

void SelectSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        min = i;
        for(j=i+1;j<n;j++){
            if(A[j].key<A[min].key){
                min = j;
            }
        }
        if(min!=j)
            swap(A[min],A[i]);
    }
}

void SelectSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        min=i;
        for(j=i+1;j<n;j++){
            if(A[j].key<A[min].key)
                min=j;
        }
        if(min!=j)
            swap(A[i],A[min]);
    }
}

void BuildMaxHeap(ElemType A[],int n){
    for(i=n/2;i.0;i--){
        AdjustDown(A,i,);
    }
}
void AdjustDown(ElemType A[],int k,int n){
    A[0] = A[k];
    for(i=k*2;i<=n;i*=2){
        if(A[i+1].key>A[i].key)
            i++;
        if(A[0].key>A[i].key)
            break;
        else{
            A[k]=A[i];
            k=i;
        }
    }
    A[k]=A[0];
}
void HeapSort(ElemType A[],int n){
    BuildMaxHeap(A,n);
    for(i=n;i>1;i--){
        swap(A[i],A[1]);
        AdjustDown(A,1,i-1);
    }
}

void BuildMaxHeap(ElemType A[],int n){
    for(i=n/2;i>0;i--){
        AdjustDown(A,i,n);
    }
}
void AdjustDown(ElemType A[],int k,int n){
    A[0] = A[k];
    for(i=k*2;i<=n;i*=2){
        if(A[i].key<A[i+1].key)
            i++;
        if(A[i].key<A[0].key)
            break;
        else{
            A[k] = A[i];
            k=i;
        }
    }
    A[k]=A[0];
}
void HeapSort(ElemType A[],int n){
    BuildMaxHeap(A,n);
    for(i=n;i>0;i--){
        swap(A[i],A[1]);
        AdjustDown(A,1,i-1);
    }
}

void MergeSort(ElemType A[],int low,int high){
    if(low<high){
        int mid=(low+high)/2;
        MergeSort(A,low,mid);
        MergeSort(A,mid+1,high);
        Merge(A,low,mid,high);
    }
}
void Merge(ElemType A[],int low,int mid,int high){
    for(i=low;i<=high;i++){
        B[i] = A[i];
    }
    for(i=low,j=mid+1,k=i;i<=mid&&j<=high;k++){
        if(B[i]<B[j])
            A[k] = B[i++];
        else
            A[k] = B[j++];
    }
    while(i<=mid)
        A[k++] = B[i++];
    while(j<=high)
        A[k++] = B[j++];
}

void MergeSort(ElemType A[],int low,int high){
    if(low<high){
        int mid = (low+high)/2;
        MergeSort(A,low,mid);
        MergeSort(A,mid+1,high);
        Merge(A,low,mid,high);
    }
}
void Merge(ElemType A[],int low,int mid,int high){
    for(i=low;i<=high;i++){
        B[i] = A[i];
    }
    for(i=low;j=mid+1,k=low;i<=mid&&j<=high;k++){
        if(B[i]<B[j])
            A[k] = B[i++];
        else
            A[k] = B[j++]
    }
    while(i<=mid)
        A[k++] = B[i++];
    while(j<=high)
        A[k++] = B[j++];
}
//直接插入排序
void InsertSort(ElemType A[],int n){
    for(i=2;i<=n;i++){
        if(A[i].key<A[i-1].key){
            A[0] = A[i];
            for(j=i-1;A[j].key>A[0].key;j--)
                A[j+1] = A[j];
            A[j+1] = A[0];
        }
    }
}
//折半插入排序
void InsertSort(ElemType A[],int n){
    for(i=2;i<=n;i++){
        A[0] = A[i];
        low=1;
        high=i-1;
        while(low<=high){
            mid=(low+high)/2;
            if(A[mid].key>A[0].key)
                high=mid-1;
            else
                low=mid+1;
        }
        for(j=i-1;j>=high+1;j--)
            A[j+1] = A[j];
        A[high+1] = A[0];
    }
}
//希尔排序
void ShellSort(ElemType A[],int n){
    for(dk=n/2;dk>=1;dk/=2){
        for(i=dk+1;i<=n;i++){
            if(A[i].key<A[i-dk].key){
                A[0] = A[i];
                for(j=i-dk;j>0&&A[j].key>A[0].key;j-=dk)
                    A[j+dk] = A[j];
                A[j+dk] = A[0];
            }
        }
    }
}
//冒泡排序
void BubbleSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        flag = flase;
        for(j=n-1;j>i;j--){
            if(A[j-1].key>A[j].key){
                swap(A[j],A[j-1]);
                flag=true;
            }
        }
        if(flag==false)
            break;
    }
}
//快速排序
void QuickSort(ElemType A[],int low,int high){
    if(low<high){
        int pivotpos = Partition(A,low,high);
        QuickSort(A,low,pivotpos-1);
        QuickSort(A,pivotpos+1,high);
    }
}
int Partition(ElemType A[],int low,int high){
    ElemType pivot = A[low];
    while(low<high){
        while(low<high&&A[high]>=pivot)
            high--;
        while(low<high&&A[low]<=pivot)
            low++;
    }
    A[low] = pivot;
    return low;
}
//简单选择排序
void SelectSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        min=i;
        for(j=i+1;j<n;j++){
            if(A[j]<A[min])
                min=j;
        }
        if(min!=i)
            swap(A[min],A[i]);
    }
}
//堆排序
void HeapSort(ElemType A[],int n){
    BuildMaxHeap(A,n);
    for(i=n;i>1;i--){
        swap(A[i],A[1]);
        AdjustDown(A,1,i-1);
    }
}
void BuildMaxHeap(ElemType A[],int n){
    for(i=n/2;i>0;i--){
        AdjustDown(A,i,n);
    }
}
void AdjustDown(ElemType A[],int k,int n){
    A[0] = A[k];
    for(i=k*2;i<=n;i*=2){
        if(i<n&&A[i+1]>A[i])
            i++;
        if(A[0]>A[i])
            break;
        else{
            A[k] = A[i];
            k=i;
        }
    }
    A[k]=A[0];
}
//归并排序
void MergeSort(ElemType A[],int low,int high){
    if(low<high){
        mid=(low+high)/2;
        MergeSort(A,low,mid);
        MergeSort(A,mid+1,high);
        Merge(A,low,mid,high);
    }
}
void Merge(ElemType A[],int low,int mid,int high){
    for(i=low;i<=high;i++){
        B[i] = A[i];
    }
    for(i=low,j=mid+1,k=low;i<=mid&&j<=high;k++){
        if(B[i]<B[j])
            A[k] = B[i++];
        else
            A[k] = B[j++];
    }
    while(i<=mid)
        A[k++] = B[i++];
    while(j<=high)
        A[k++] = B[j++];
}

void InsertSort(ElemType A[],int n){
    for(i=2;i<=n;i++){
        if(A[i].key<A[i-1.key]){
            A[0] = A[i];
            for(j=i-2;A[j].key>A[0].key;j--)
                A[j+1] = A[j];
            A[j+1] = A[0];
        }
    }
}
void InsertSort(ElemType A[],int n){
    for(i=2;i<=n;i++){
        A[0] = A[i];
        low=1;
        high=i-1;
        while(low<=high){
            mid=(low+high)/2;
            if(A[mid].key<A[0].key)
                low = mid+1;
            else
                high=mid-1;
        }
        for(j=i-1;j>high+1;j--)
            A[j+1] = A[j];
        A[high+1] = A[0];
    }
}
void ShellSort(ElemType A[],int n){
    for(dk=n/2;dk>=1;dk/=2){
        for(i=dk+1;i<=n;i++){
            if(A[i].key<A[i-dk]){
                A[0] = A[i];
                for(j=i-dk;j>0&&A[j].key>A[0].key;-=dk)
                    A[j+dk] = A[j];
                A[j+dk] = A[0];
            }
        }
    }
}
void BubbleSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        flag = false;
        for(j=n-1;j>i;j--){
            if(A[j].key<A[j-1].key){
                swap(A[j],A[j-1]);
                flag = true;
            }
        }
        if(flag==false)
            return;
    }
}
void QuickSort(ElemType A[],int low,int high){
    if(low<high){
        int pivotpos = Partition(A,low,high);
        QuickSort(A,low,pivotpos-1);
        QuickSort(A,pivotpos+1,high);
    }
}
int Partition(ElemType A[],int low,int high){
    ElemType pivot = A[low];
    while(low<high){
        while(low<high&&A[high].key>=pivot)
            high--;
        while(low<high&&A[low].key<=pivot)
            low++;
    }
    A[low] = pivot;
    return low;
}
void SelectSort(ElemType A[],int n){
    for(i=0;i<n-1;i++){
        min=i;
        for(j=i+1;j<n;j++){
            if(A[j].key<A[min].key)
                min = j;
        }
        if(min!=i)
            swap(A[i],A[min]);
    }
}
void HeapSort(ElemType A[],int n){
    BuildMaxHeap(A,n);
    for(i=n;i>1;i--){
        swap(A[i],A[1]);
        AdjustDown(A,1,i-1);
    }
}
void AdjustDown(ElemType A[],int k,int n){
    A[0] = A[k];
    for(i=k*2;i<=n;i*=2){
        if(i<n&&A[i].key<A[i+1].key)
            i++;
        if(A[0].key>A[i].key)
            break;
        else{
            A[k] = A[i];
            k=i;
        }
    }
    A[k] = A[0];
}
void BuildMaxHeap(ElemType A[],int n){
    for(i=n/2;i>=1;i--){
        AdjustDown(A,i,n);
    }
}
void MergeSort(ElemType A[],int low,int high){
    if(low<high){
        int mid = (low+high)/2;
        MergeSort(A,low,mid);
        MergeSort(A,mid+1,high);
        Merge(A,low,mid,high);
    }
}
void Merge(ElemType A[],int low,int mid,int high){
    for(i=low;i<=high;i++){
        B[i] = A[i];
    }
    for(i=low,j=mid+1,k=low;i<=mid&&j<=high;k++){
        if(B[i]<B[j])
            A[k] = B[i++];
        else
            A[k] = B[j++];
    }
    while(i<=mid)
        A[k++] = B[i++];
    while(j<=high)
        A[k++] = B[j++];
}
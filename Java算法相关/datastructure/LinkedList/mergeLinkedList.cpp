Node *ListMerge1(Node *head1,Node *head2)//采用递归的方法实现
{
	if(head1==NULL)
		return head2;
	if(head2==NULL)
		return head1;
	Node *head=NULL;
	if(head1->value < head2->value)
	{
		head=head1;
		head->next=ListMerge1(head1->next,head2);
	}
	else
	{
		head=head2;
		head->next=ListMerge1(head1,head2->next);
	}
	return head;
}
